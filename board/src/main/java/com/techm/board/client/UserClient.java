package com.techm.board.client;

import com.techm.board.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//@FeignClient(name="users-service", url="localhost:8100")
@FeignClient(name="users-service")
public interface UserClient {

    @GetMapping(path= "user/{userId}")
    Optional<User> getOneUser(
            @PathVariable("userId") Long userId);

}
