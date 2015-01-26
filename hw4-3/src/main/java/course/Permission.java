package course;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DB;
import com.mongodb.DBObject;

/**
 * Created by SEA_HAWK on 13-Nov-14.
 */
public class Permission {
    private final DBCollection permissionCollection;
    public Permission(final DB database){
        permissionCollection=database.getCollection("permissions");
    }
    boolean isPermitted(String template,int userGroup){
        DBObject doc=permissionCollection.findOne(new BasicDBObject("template",template).append("user_group",userGroup));
        System.out.println(doc.get("template").toString());
        if(doc==null){
            return false;
        }
        else{
            return true;
        }
    }
}
