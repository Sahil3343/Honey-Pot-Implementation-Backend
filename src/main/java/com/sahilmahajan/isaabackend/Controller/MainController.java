package com.sahilmahajan.isaabackend.Controller;

import com.sahilmahajan.isaabackend.Operations.LoginAuthentication;
import com.sahilmahajan.isaabackend.Operations.StoreUserDetails;
import com.sahilmahajan.isaabackend.Utils.LoginAuthResultUtil;
import com.sahilmahajan.isaabackend.Utils.LoginAuthUtil;
import com.sahilmahajan.isaabackend.Utils.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @CrossOrigin(origins = "http://localhost")
    @PostMapping(value = "/login", consumes = "application/json")
    public LoginAuthResultUtil LoginAuth(@RequestBody LoginAuthUtil loginAuthUtil) {
        System.out.println(loginAuthUtil.getUsername());
        LoginAuthentication authentication = new LoginAuthentication();
        return authentication.LoginAuthentication(loginAuthUtil);
    }

    @CrossOrigin(origins = "http://localhost")
    @PostMapping(value = "/userdetails", consumes = "application/json")
    public void UserDetails(@RequestBody UserDetails userDetails) {
        System.out.println(userDetails.getAppCodeName());
        StoreUserDetails storeUserDetails = new StoreUserDetails();
        storeUserDetails.StoreDetails(userDetails);
    }
}
