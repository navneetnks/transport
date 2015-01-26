package course;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringEscapeUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.*;

/**
 * This class encapsulates the controllers for the blog web application.  It delegates all interaction with MongoDB
 * to three Data Access Objects (DAOs).
 * <p/>
 * It is also the entry point into the web application.
 */
public class Controller {
    private final Configuration cfg;
    private final BlogPostDAO blogPostDAO;
    private final UserDAO userDAO;
    private final SessionDAO sessionDAO;

    final private String mongoURIString;
    final private String databaseStr;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            new Controller("mongodb://localhost");
            System.out.println("mongodb://localhost");
        }
        else {
            new Controller(args[0]);
            System.out.println(args[0]);
        }

    }

    public Controller(String mongoURIString) throws IOException {
        final MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoURIString));
        final DB blogDatabase = mongoClient.getDB("blog");
        this.mongoURIString=mongoURIString;
        this.databaseStr="transport";

        blogPostDAO = new BlogPostDAO(blogDatabase);
        userDAO = new UserDAO(blogDatabase);
        sessionDAO = new SessionDAO(blogDatabase);

        cfg = createFreemarkerConfiguration();
//        setIpAddress("192.168.0.103");
        staticFileLocation("/public");
        setPort(8082);
        initializeRoutes();
    }

    abstract class FreemarkerBasedRoute extends Route {
        final Template template;

        /**
         * Constructor
         *
         * @param path The route path which is used for matching. (e.g. /hello, users/:name)
         */
        protected FreemarkerBasedRoute(final String path, final String templateName) throws IOException {
            super(path);
            template = cfg.getTemplate(templateName);
        }

        @Override
        public Object handle(Request request, Response response) {
            StringWriter writer = new StringWriter();
            try {
                doHandle(request, response, writer);
            } catch (Exception e) {
                e.printStackTrace();
                response.redirect("/internal_error");
            }
            return writer;
        }

        protected abstract void doHandle(final Request request, final Response response, final Writer writer)
                throws IOException, TemplateException;

    }

    private void initializeRoutes() throws IOException {


       //handle the signup post
        post(new FreemarkerBasedRoute("/signup", "signup.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                String email = request.queryParams("email");
                String username = request.queryParams("username");
                String password = request.queryParams("password");
                String verify = request.queryParams("verify");

                HashMap<String, String> root = new HashMap<String, String>();
                root.put("username", StringEscapeUtils.escapeHtml4(username));
                root.put("email", StringEscapeUtils.escapeHtml4(email));

                if (validateSignup(username, password, verify, email, root)) {
                    // good user
                    System.out.println("Signup: Creating user with: " + username + " " + password);
                    DBConnection dbConnection=new DBConnection(mongoURIString,databaseStr);
                    dbConnection.open();
                    if (!new UserDAO(dbConnection.getDatabase()).addUser(username, password, email)) {
                        // duplicate user
                        root.put("username_error", "Username already in use, Please choose another");
                        template.process(root, writer);
                    }
                    else {
                        // good user, let's start a session
                        String sessionID = sessionDAO.startSession(username);
                        System.out.println("Session ID is" + sessionID);

                        response.raw().addCookie(new Cookie("session", sessionID));
                        response.redirect("/welcome");
                    }
                    dbConnection.close();
                }
                else {
                    // bad signup
                    System.out.println("User Registration did not validate");
                    template.process(root, writer);
                }
            }
        });

        // present signup form for blog
        get(new FreemarkerBasedRoute("/signup", "signup.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer)
                    throws IOException, TemplateException {

                SimpleHash root = new SimpleHash();

                // initialize values for the form.
                root.put("username", "");
                root.put("password", "");
                root.put("email", "");
                root.put("password_error", "");
                root.put("username_error", "");
                root.put("email_error", "");
                root.put("verify_error", "");

                template.process(root, writer);
            }
        });



        // handle the new post submission


        get(new FreemarkerBasedRoute("/welcome", "welcome.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {

                String cookie = getSessionCookie(request);
                DBConnection dbConnection=new DBConnection(mongoURIString,databaseStr);
                dbConnection.open();
                String username = new SessionDAO(dbConnection.getDatabase()).findUserNameBySessionId(cookie);
                dbConnection.close();

                if (username == null) {
                    System.out.println("welcome() can't identify the user, redirecting to signup");
                    response.redirect("/signup");

                }
                else {
                    SimpleHash root = new SimpleHash();

                    root.put("username", username);

                    template.process(root, writer);
                }
            }
        });



        // present the login page
        get(new FreemarkerBasedRoute("/login", "login.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root = new SimpleHash();

                root.put("username", "");
                root.put("login_error", "");

                template.process(root, writer);
            }
        });

        // process output coming from login form. On success redirect folks to the welcome page
        // on failure, just return an error and let them try again.
        post(new FreemarkerBasedRoute("/login", "login.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {

                String username = request.queryParams("username");
                String password = request.queryParams("password");

                System.out.println("Login: User submitted: " + username + "  " + password);
                DBConnection dbConnection=new DBConnection(mongoURIString,databaseStr);
                dbConnection.open();
                DBObject user = new UserDAO(dbConnection.getDatabase()).validateLogin(username, password);


                if (user != null) {

                    // valid user, let's log them in

                    String sessionID = new SessionDAO(dbConnection.getDatabase()).startSession(user.get("_id").toString());
                    if (sessionID == null) {
                        response.redirect("/internal_error");
                    }
                    else {
                        // set the cookie for the user's browser
                        response.raw().addCookie(new Cookie("session", sessionID));

                        response.redirect("/welcome");
                    }
                }
                else {
                    SimpleHash root = new SimpleHash();


                    root.put("username", StringEscapeUtils.escapeHtml4(username));
                    root.put("password", "");
                    root.put("login_error", "Invalid Login");
                    template.process(root, writer);
                }
                dbConnection.close();
            }
        });

        // Show the posts filed under a certain tag

        // will allow a user to click Like on a post


        // tells the user that the URL is dead
        get(new FreemarkerBasedRoute("/post_not_found", "post_not_found.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root = new SimpleHash();
                template.process(root, writer);
            }
        });

        // allows the user to logout of the blog
        get(new FreemarkerBasedRoute("/logout", "signup.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {

                String sessionID = getSessionCookie(request);

                if (sessionID == null) {
                    // no session to end
                    response.redirect("/login");
                }
                else {
                    // deletes from session table
                    DBConnection dbConnection=new DBConnection(mongoURIString,databaseStr);
                    dbConnection.open();
                    new SessionDAO(dbConnection.getDatabase()).endSession(sessionID);
                    dbConnection.close();

                    // this should delete the cookie
                    Cookie c = getSessionCookieActual(request);
                    c.setMaxAge(0);

                    response.raw().addCookie(c);

                    response.redirect("/login");
                }
            }
        });


        // used to process internal errors
        get(new FreemarkerBasedRoute("/internal_error", "error_template.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root = new SimpleHash();

                root.put("error", "System has encountered an error.");
                template.process(root, writer);
            }
        });

        // home get
        get(new FreemarkerBasedRoute("/home", "home.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root = new SimpleHash();
                String username = sessionDAO.findUserNameBySessionId(getSessionCookie(request));
                root.put("username", username);
                template.process(root, writer);
            }
        });
        // consignement get
        get(new FreemarkerBasedRoute("/consignment", "consignment.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {

                template.process(new Consignment().getTemplateMap(), writer);
            }
        });
        // consignment post
        post(new FreemarkerBasedRoute("/consignment", "consignment.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                Consignment consignment = new Consignment(request);
                consignment.saveConsignment(mongoURIString,databaseStr);
                response.redirect("/home");
            }
        });
        get(new FreemarkerBasedRoute("/form", "form1.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                template.process(root, writer);
            }
        });

        get(new FreemarkerBasedRoute("/billty", "/transport/bility.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                root.put("consign",new Consignment().getTemplateMap());
                template.process(root, writer);
            }
        });
        post(new FreemarkerBasedRoute("/billty", "/transport/bility.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                Consignment consignment = new Consignment(request);
                consignment.saveConsignment(mongoURIString,databaseStr);
                response.redirect("/thome");
            }
        });
        get(new FreemarkerBasedRoute("/update", "/transport/bility.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();

                root.put("consign",new Consignment().getConsignmentByID(mongoURIString,databaseStr,"NAV"));
                template.process(root, writer);
            }
        });
        get(new FreemarkerBasedRoute("/thome", "/transport/home.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                template.process(root, writer);
            }
        });
        get(new FreemarkerBasedRoute("/tsettings", "/transport/settings.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                template.process(root, writer);
            }
        });
        get(new FreemarkerBasedRoute("/truckunl", "/transport/truckunloading.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                template.process(root, writer);
            }
        });
        get(new FreemarkerBasedRoute("/gatePass", "/transport/gatePassEntry.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                template.process(root, writer);
            }
        });

        get(new FreemarkerBasedRoute("/urlTest", "urlTest.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                root.put("firstName",request.queryParams("firstName")==null?"":request.queryParams("firstName"));
                root.put("lastName",request.queryParams("lastName")==null?"":request.queryParams("lastName"));
                if(request.queryParams("firstName")!=""){
                    System.out.println("get firstName: "+ request.queryParams("firstName"));
                    System.out.println("get lastName: "+ request.queryParams("lastName"));
                }
                template.process(root, writer);
            }
        });
        post(new FreemarkerBasedRoute("/urlTest", "urlTest.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root=new SimpleHash();
                System.out.println("firstName: "+ request.queryParams("firstName"));
                System.out.println("lastName: "+ request.queryParams("lastName"));
                response.redirect("/login");
            }
        });

    }

    // helper function to get session cookie as string
    private String getSessionCookie(final Request request) {
        if (request.raw().getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.raw().getCookies()) {
            if (cookie.getName().equals("session")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    // helper function to get session cookie as string
    private Cookie getSessionCookieActual(final Request request) {
        if (request.raw().getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.raw().getCookies()) {
            if (cookie.getName().equals("session")) {
                return cookie;
            }
        }
        return null;
    }

    // tags the tags string and put it into an array
    private ArrayList<String> extractTags(String tags) {

        // probably more efficent ways to do this.
        //
        // whitespace = re.compile('\s')

        tags = tags.replaceAll("\\s", "");
        String tagArray[] = tags.split(",");

        // let's clean it up, removing the empty string and removing dups
        ArrayList<String> cleaned = new ArrayList<String>();
        for (String tag : tagArray) {
            if (!tag.equals("") && !cleaned.contains(tag)) {
                cleaned.add(tag);
            }
        }

        return cleaned;
    }

    // validates that the registration form has been filled out right and username conforms
    public boolean validateSignup(String username, String password, String verify, String email,
                                  HashMap<String, String> errors) {
        String USER_RE = "^[a-zA-Z0-9_-]{3,20}$";
        String PASS_RE = "^.{3,20}$";
        String EMAIL_RE = "^[\\S]+@[\\S]+\\.[\\S]+$";

        errors.put("username_error", "");
        errors.put("password_error", "");
        errors.put("verify_error", "");
        errors.put("email_error", "");

        if (!username.matches(USER_RE)) {
            errors.put("username_error", "invalid username. try just letters and numbers");
            return false;
        }

        if (!password.matches(PASS_RE)) {
            errors.put("password_error", "invalid password.");
            return false;
        }


        if (!password.equals(verify)) {
            errors.put("verify_error", "password must match");
            return false;
        }

        if (!email.equals("")) {
            if (!email.matches(EMAIL_RE)) {
                errors.put("email_error", "Invalid Email Address");
                return false;
            }
        }

        return true;
    }

    private Configuration createFreemarkerConfiguration() {
        Configuration retVal = new Configuration();
        retVal.setClassForTemplateLoading(Controller.class, "/freemarker");
        return retVal;
    }
}


