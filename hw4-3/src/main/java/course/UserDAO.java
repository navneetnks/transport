/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package course;

import com.mongodb.*;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class UserDAO {
    private DBCollection usersCollection;
    private DBCollection orgCollection;
    private Random random = new SecureRandom();
    private String mongoURIString;
    private String databaseStr;

    public UserDAO(final DB blogDatabase) {
        usersCollection = blogDatabase.getCollection("users");
        orgCollection=blogDatabase.getCollection("organizations");

    }


    // validates that username is unique and insert into db
    public boolean addUser(String username, String password, String email) {
    //public boolean addUser(String username, String password, String email, int userGroup,String createdBy,String firstName, String lastName) {

        String passwordHash = makePasswordHash(password, Integer.toString(random.nextInt()));


//                BasicDBObject user = new BasicDBObject();
//        user.append("_id", username).append("password", passwordHash).append("user_group",userGroup)
//        .append("created_dt",new java.util.Date()).append("first_name",firstName).append("last_name",lastName);

        BasicDBObject user = new BasicDBObject();
        user.append("_id", username).append("password", passwordHash);
//        if(createdBy != null) {
//            DBObject createdByDoc = usersCollection.findOne(new BasicDBObject("_id", username));
//            BasicDBObject orgDoc = new BasicDBObject("id", createdByDoc.get("organization.id")).append("name", createdByDoc.get("organization.name"))
//                    .append("db", createdByDoc.get("db"));
//            user.append("organization",orgDoc);
//        }
        if (email != null && !email.equals("")) {
            // the provided email address
            user.append("email", email);
        }
//        if (userGroup==1) {
//            // the provided email address
//            user.append("created_by", createdBy);
//        }

        try {
            usersCollection.insert(user);
            return true;
        } catch (MongoException.DuplicateKey e) {
            System.out.println("Username already in use: " + username);
            return false;
        }
    }

    public DBObject validateLogin(String username, String password) {
        DBObject user;

        user = usersCollection.findOne(new BasicDBObject("_id", username));

        if (user == null) {
            System.out.println("User not in database");
            return null;
        }

        String hashedAndSalted = user.get("password").toString();

        String salt = hashedAndSalted.split(",")[1];

        if (!hashedAndSalted.equals(makePasswordHash(password, salt))) {
            System.out.println("Submitted password is not a match");
            return null;
        }

        return user;
    }
    public int getUserGroup(String username){
        String userGroup=usersCollection.findOne(new BasicDBObject("_id", username)).get("user_group").toString();
        System.out.println("String User_group="+userGroup);
        return (int)Float.parseFloat(userGroup);
    }

    private String makePasswordHash(String password, String salt) {
        try {
            String saltedAndHashed = password + "," + salt;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(saltedAndHashed.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
            return encoder.encode(hashedBytes) + "," + salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 is not available", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 unavailable?  Not a chance", e);
        }
    }
}
