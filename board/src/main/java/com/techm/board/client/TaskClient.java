package com.techm.board.client;

import com.techm.board.domain.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name="tasks-service", url= "localhost:8200")
public interface TaskClient {

    @GetMapping(path= "task/{taskId}")
    Optional<Task> getOneTask(
            @PathVariable("taskId") Long taskId);

    @GetMapping(path="task/user/{userId}")
    List<Task> tasksByUserId(
            @PathVariable("userId") Long userId);

}
