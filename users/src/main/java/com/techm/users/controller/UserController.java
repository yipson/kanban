package com.techm.users.controller;

import com.techm.users.domain.User;
import com.techm.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserService userService;

    @GetMapping(path= "{userId}")
    public Optional<User> getOneUser(
            @PathVariable("userId") Long userId){
        return userService.getOneUser(userId);
    }

    @GetMapping
    public List<User> listUsers(){
        User user = new User(
                "a",
                "a",
                "a",
                "a",
                environment.getProperty("local.server.port")
                );
        return List.of(user);
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }



}
