package com.sahilmahajan.isaabackend.Utils;

public class LoginAuthResultUtil {

    private boolean LoginStatus;
    private int LoginAttempts;

    public boolean isLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }

    public int getLoginAttempts() {
        return LoginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        LoginAttempts = loginAttempts;
    }
}
