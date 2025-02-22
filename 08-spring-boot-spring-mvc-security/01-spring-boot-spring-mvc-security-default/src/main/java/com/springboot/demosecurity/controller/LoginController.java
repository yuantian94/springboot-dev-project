package com.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        //return "plain-login";
        return "fancy-login";
    }

    // add request mapping for /access-denied, you can add the controller mapping anywhere
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
