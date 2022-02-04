package com.techm.users.controller;

import com.techm.users.domain.User;
import com.techm.users.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "login")
    public String login(@RequestBody User user){
        return authService.getToken(user);
    }
}
