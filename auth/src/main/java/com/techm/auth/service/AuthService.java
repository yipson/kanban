package com.techm.auth.service;

import com.techm.auth.domain.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface AuthService {

    Optional<User> getOneUser(
            @PathVariable("userId") Long userId);
}
