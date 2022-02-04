package com.techm.loginregister.service;

import com.techm.loginregister.domain.User;

public interface AuthService {

    boolean verifyCredentials(User user);
}
