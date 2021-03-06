package com.techm.users.service;

import com.techm.users.client.AuthClient;
import com.techm.users.domain.User;
import com.techm.users.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthClient authClient;

    @Override
    public String getToken(User user) {
        User userLogin = userService.returnUserByCredentials(user);

        if (userLogin != null ){

            String token = jwtUtil.create(String.valueOf(userLogin.getId()),
                    userLogin.getEmail());

            return token;
        }

        return "FAIL";
    }

    @Override
    public boolean verifyToken(String token) {
        return authClient.verifyToken(token);
    }


}
