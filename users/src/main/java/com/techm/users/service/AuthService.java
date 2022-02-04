package com.techm.users.service;

import com.techm.users.domain.User;

public interface AuthService {

    String getToken(User user);

    boolean verifyToken(String token);
}
