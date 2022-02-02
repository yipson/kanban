package com.techm.users.controller;

import com.techm.users.domain.User;
import com.techm.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }
}
