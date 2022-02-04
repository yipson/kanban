package com.techm.auth.service;

import com.techm.auth.client.UserClient;
import com.techm.auth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserClient userClient;

    @Override
    public Optional<User> getOneUser(Long userId) {
        return userClient.getOneUser(userId);
    }
}
