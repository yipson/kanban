package com.techm.users.service;

import com.techm.users.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getOneUser(Long userId);

    List<User> listUsers();

    void addUser(User user);

    User returnUserByCredentials(User user);
}
