package com.techm.users.controller;

import com.techm.users.domain.User;
import com.techm.users.repository.UserRepository;
import com.techm.users.service.AuthService;
import com.techm.users.service.UserService;
import com.techm.users.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @GetMapping(path= "{userId}")
    public Optional<User> getOneUser(
            @PathVariable("userId") Long userId,
            @RequestHeader(value="Authorization") String token){

        boolean isTokenValid = authService.verifyToken(token);

        if(!isTokenValid){
            throw new IllegalStateException("Token Invalid");
        }

        return userService.getOneUser(userId);
    }

    @PostMapping(path= "register")
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }

}
