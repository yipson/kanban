package com.techm.tasks.controller;

import com.techm.tasks.domain.Task;
import com.techm.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path= "{taskId}")
    public Optional<Task> getOneTask(
            @PathVariable("taskId") Long taskId){
        return taskService.getOneTask(taskId);
    }

    @GetMapping
    public List<Task> listTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void registerTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @PostMapping(path= "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestBody Task task){
        taskService.updateTask(taskId, task);
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTask(
            @PathVariable("taskId") Long taskId){
        taskService.deleteById(taskId);
    }
}
