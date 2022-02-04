package com.techm.auth.controller;

import com.techm.auth.domain.User;
import com.techm.auth.service.AuthService;
import com.techm.auth.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @GetMapping
    public boolean verifyToken(String token){
        Long idToken = Long.valueOf(jwtUtil.getKey(token));
        if (idToken == null || idToken <= 0){
            return false;
        }
        Optional<User> isUserPresent =
                authService.getOneUser(idToken);
        if(isUserPresent.isEmpty()){
            return false;
        }
        return true;
    }
}
