package com.techm.loginregister.controller;

import com.techm.loginregister.domain.User;
import com.techm.loginregister.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public void registerUser(@RequestBody User user){
        registerService.addUser(user);
    }
}
