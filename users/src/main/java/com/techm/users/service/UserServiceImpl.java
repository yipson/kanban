package com.techm.users.service;

import com.techm.users.domain.User;
import com.techm.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getOneUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()){
            return userOptional;
        }

        throw new IllegalStateException("invalid user id");
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

}
