package com.techm.loginregister.service;

import com.techm.loginregister.domain.User;
import com.techm.loginregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean verifyCredentials(User user) {
        List<User> isUserPresent =
                userRepository.verifyCredentials(user.getEmail(), user.getPassword());

        return !isUserPresent.isEmpty();
    }
}
