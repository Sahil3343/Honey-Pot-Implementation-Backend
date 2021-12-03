package com.sahilmahajan.isaabackend.Operations;

import com.sahilmahajan.isaabackend.Utils.UserDetails;
import org.bson.Document;

public class StoreUserDetails {

    MongoDB mongoDB = new MongoDB();

    public boolean StoreDetails(UserDetails userDetails) {

        try {
            MongoDB.Connect("ISAA", "UserCreds");

            Document Store = new Document("AppCodeName", userDetails.getAppCodeName())
                    .append("AppVersion", userDetails.getAppVersion())
                    .append("UserAgent", userDetails.getUserAgent())
                    .append("OS", userDetails.getOperatingSystem())
                    .append("IP", userDetails.getIP())
                    .append("Latitude", userDetails.getLatitude())
                    .append("Longitude", userDetails.getLongitude());

            mongoDB.getcollection().insertOne(Store);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }


}
