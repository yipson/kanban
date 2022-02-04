package com.techm.loginregister.controller;

import com.techm.loginregister.domain.User;
import com.techm.loginregister.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "login")
    public String login(@RequestBody User user){
        if (authService.verifyCredentials(user)){
            return "ok";
        }
        return "fail";
    }
}
