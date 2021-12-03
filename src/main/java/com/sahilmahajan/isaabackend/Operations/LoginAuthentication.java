package com.sahilmahajan.isaabackend.Operations;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sahilmahajan.isaabackend.Utils.BCrypt;
import com.sahilmahajan.isaabackend.Utils.LoginAuthResultUtil;
import com.sahilmahajan.isaabackend.Utils.LoginAuthUtil;
import org.bson.Document;

public class LoginAuthentication {

    MongoDB mongoDB = new MongoDB();

    public LoginAuthResultUtil LoginAuthentication(LoginAuthUtil loginAuthUtil) {

        LoginAuthResultUtil loginAuthResultUtil = new LoginAuthResultUtil();

        String Salt = "$2a$12$XCVUHMLtK2cyU4nzbczrWe";
        String Hash = BCrypt.hashpw(loginAuthUtil.getPassword(), Salt);

        try {
            MongoDB.Connect("ISAA", "UserCreds");

            Document ValidateUser = mongoDB.getcollection().find(Filters.and(Filters.eq("Username", loginAuthUtil.getUsername()), Filters.eq("Password", Hash))).first();

            if (ValidateUser != null) {
                loginAuthResultUtil.setLoginStatus(true);
                return loginAuthResultUtil;
            }

            Document GetAttempts = mongoDB.getcollection().find(Filters.eq("Username", loginAuthUtil.getUsername())).first();

            mongoDB.getcollection().updateOne(Filters.eq("Username", loginAuthUtil.getUsername()),
                    Updates.set("Attempts", GetAttempts.getInteger("Attempts") + 1));

            if (GetAttempts == null) {
                loginAuthResultUtil.setLoginStatus(false);
                return loginAuthResultUtil;
            }

            if (GetAttempts.getInteger("Attempts") == 3) {
                loginAuthResultUtil.setLoginStatus(false);
                loginAuthResultUtil.setLoginAttempts(3);

                mongoDB.getcollection().updateOne(Filters.eq("Username", loginAuthUtil.getUsername()),
                        Updates.set("Attempts", 0));

                return loginAuthResultUtil;
            }

            loginAuthResultUtil.setLoginAttempts(GetAttempts.getInteger("Attempts"));
            loginAuthResultUtil.setLoginStatus(false);

            return loginAuthResultUtil;

        } catch (Exception exception) {
            exception.printStackTrace();
            return loginAuthResultUtil;
        }
    }
}
