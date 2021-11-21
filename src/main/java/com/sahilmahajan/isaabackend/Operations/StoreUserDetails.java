package com.sahilmahajan.isaabackend.Operations;

import com.sahilmahajan.isaabackend.Utils.UserDetails;
import org.bson.Document;

public class StoreUserDetails {

    MongoDB mongoDB = new MongoDB();

    public boolean StoreDetails(UserDetails userDetails) {

        try {
            MongoDB.Connect("", "");

            Document Store = new Document("Username", "");

            mongoDB.getcollection().insertOne(Store);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }


}
