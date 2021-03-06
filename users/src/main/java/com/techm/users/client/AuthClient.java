package com.techm.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="auth-service")
public interface AuthClient {

    @GetMapping(path="auth")
    boolean verifyToken(String token);
}
