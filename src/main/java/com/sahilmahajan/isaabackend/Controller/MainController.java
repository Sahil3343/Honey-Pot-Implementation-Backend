package com.sahilmahajan.isaabackend.Controller;

import com.sahilmahajan.isaabackend.Operations.LoginAuthentication;
import com.sahilmahajan.isaabackend.Utils.LoginAuthResultUtil;
import com.sahilmahajan.isaabackend.Utils.LoginAuthUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PostMapping("/login")
    public LoginAuthResultUtil LoginAuth(@RequestBody LoginAuthUtil loginAuthUtil) {
        LoginAuthentication authentication = new LoginAuthentication();
        return authentication.LoginAuthentication(loginAuthUtil);
    }
}
