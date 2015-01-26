package course;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

/**
 * Created by SEA_HAWK on 10-Jan-15.
 */
public class DBConnection {
    private MongoClient mongoClient;
    private DB database;
    private String mongoURIString;
    private String databaseStr;


    public DBConnection(String mongoURIString, String databaseStr) {

        this.mongoURIString = mongoURIString;
        this.databaseStr = databaseStr;
    }

    public void open(){
        try{
            mongoClient=new MongoClient(new MongoClientURI(mongoURIString));
        }
        catch(UnknownHostException e){
            System.out.println("Exception caught in DB connection: "+e.getStackTrace());
        }
        database=mongoClient.getDB(databaseStr);
        System.out.println("Database Connection opened for URL="+mongoClient.getConnectPoint()+"\t Database="+database.getName());
    }
    public void close(){
        this.mongoClient.close();
        System.out.println("Database Connection Closed");
    }
    public DB getDatabase(){
        return database;
    }
    public MongoClient getMongoClient(){
        return mongoClient;
    }
    public String getMongoURI(){
        return mongoURIString;
    }
    public String getDatabaseName(){
        return databaseStr;
    }

}
