package com.techm.auth.client;

import com.techm.auth.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="users-service")
public interface UserClient {

    @GetMapping(path= "user/{userId}")
    Optional<User> getOneUser(
            @PathVariable("userId") Long userId);

}