package course;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SEA_HAWK on 10-Jan-15.
 */
public class Consignment {
    private Map<String,Object> templateMap;
    final private String consignmentCollName="consignment";


    public Consignment(){
        templateMap=new HashMap<String, Object>();
        templateMap.put("_id", "");
        templateMap.put("fromLoc", "");
        templateMap.put("toLoc", "");
        templateMap.put("bookDate", "");
        templateMap.put("bookingBranch", "");
        templateMap.put("consignor", "");
        templateMap.put("consignee", "");
        templateMap.put("stPaid", "");
        templateMap.put("bookingFor", "");
        templateMap.put("mode", "");
        templateMap.put("Billty", "");
        templateMap.put("station", "");
        templateMap.put("formNo", "formNo");

        templateMap.put("advance", "");
        templateMap.put("private", "");
        templateMap.put("truckNo", "");
        templateMap.put("rate", "");
        templateMap.put("value", "");
        templateMap.put("billedOn", "");
        templateMap.put("type", "");
        templateMap.put("contains", "");
        templateMap.put("partyCH", "");
        templateMap.put("cWeight", "");
        templateMap.put("aWeight", "");
        templateMap.put("packageType", "");
        templateMap.put("packages", "");
        templateMap.put("freightCharge", "");
        templateMap.put("cnType", "");
        templateMap.put("rebkglrno", "");
        templateMap.put("frtat", "");

        templateMap.put("miscCharge", "");
        templateMap.put("riskCharge", "");
        templateMap.put("doorDel", "");

        templateMap.put("stCharge", "");
        templateMap.put("stSurcharge", "");
        templateMap.put("surcharge", "");
        templateMap.put("hamali", "");


        templateMap.put("freight", "");
        
    }
    public Consignment(Request request){
        templateMap=new HashMap<String, Object>();
        templateMap.put("_id", request.queryParams("consignmentId"));
        templateMap.put("fromLoc", request.queryParams("fromLoc"));
        templateMap.put("toLoc", request.queryParams("toLoc"));
        templateMap.put("bookDate", request.queryParams("bookDate"));
        templateMap.put("bookingBranch", request.queryParams("bookingBranch"));
        templateMap.put("consignor", request.queryParams("consignor"));
        templateMap.put("consignee", request.queryParams("consignee"));
        templateMap.put("stPaid", request.queryParams("stPaid"));
        templateMap.put("bookingFor", request.queryParams("bookingFor"));
        templateMap.put("mode", request.queryParams("mode"));
        templateMap.put("Billty", request.queryParams("Billty"));
        templateMap.put("rebkglrno", request.queryParams("rebkglrno"));
        templateMap.put("advance", request.queryParams("advance"));
        templateMap.put("private", request.queryParams("private"));
        templateMap.put("truckNo", request.queryParams("truckNo"));
        templateMap.put("rate", request.queryParams("rate"));
        templateMap.put("value", request.queryParams("value"));
        templateMap.put("billedOn", request.queryParams("billedOn"));
        templateMap.put("type", request.queryParams("type"));
        templateMap.put("contains", request.queryParams("contains"));
        templateMap.put("partyCH", request.queryParams("partyCH"));
        templateMap.put("cWeight", request.queryParams("cWeight"));
        templateMap.put("aWeight", request.queryParams("aWeight"));
        templateMap.put("packageType", request.queryParams("packageType"));
        templateMap.put("packages", request.queryParams("packages"));
        templateMap.put("freightCharge", request.queryParams("freightCharge"));
        templateMap.put("cnType", request.queryParams("cnType"));

        templateMap.put("station", request.queryParams("station"));

        templateMap.put("frtat", request.queryParams("frtat"));

        templateMap.put("miscCharge", request.queryParams("miscCharge"));
        templateMap.put("riskCharge", request.queryParams("riskCharge"));
        templateMap.put("doorDel", request.queryParams("doorDel"));

        templateMap.put("stCharge", request.queryParams("stCharge"));
        templateMap.put("stSurcharge", request.queryParams("stSurcharge"));
        templateMap.put("surcharge", request.queryParams("surcharge"));
        templateMap.put("hamali", request.queryParams("hamali"));


        templateMap.put("freight", request.queryParams("freight"));

    }
    public Map<String,Object> getTemplateMap(){
        return templateMap;
    }
    public void saveConsignment(final String mongoURIString, final String databaseStr){
        DBObject consignmentObj=new BasicDBObject(templateMap);
        DBConnection dbConnection=new DBConnection(mongoURIString,databaseStr);
        dbConnection.open();
        DBCollection consignmentCollection=dbConnection.getDatabase().getCollection(consignmentCollName);
        consignmentCollection.insert(consignmentObj);
        dbConnection.close();

    }
    public void saveConsignment(final DB database){
        DBObject consignmentObj=new BasicDBObject(templateMap);
        database.getCollection(consignmentCollName).insert(consignmentObj);

    }
    public DBObject getConsignmentByID(final String mongoURIString, final String databaseStr,final String id){
        DBObject consignmentObj=new BasicDBObject(templateMap);
        DBConnection dbConnection=new DBConnection(mongoURIString,databaseStr);
        dbConnection.open();
        DBCollection consignmentCollection=dbConnection.getDatabase().getCollection(consignmentCollName);

        DBObject retObj= consignmentCollection.findOne(new BasicDBObject("_id",id));
        dbConnection.close();
        return retObj;
    }

}
