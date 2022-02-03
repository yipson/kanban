package com.techm.tasks.service;

import com.techm.tasks.domain.Status;
import com.techm.tasks.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void addTask(Task task);

    Optional<Task> getOneTask(Long taskId);

    List<Task> getTasks();

    List<Task> taskByUserId(Long userId);

    void updateTask(Long taskId, Task task);

    void deleteById(Long taskId);


}
