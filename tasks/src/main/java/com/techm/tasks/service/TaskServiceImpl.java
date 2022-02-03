package com.techm.tasks.service;

import com.techm.tasks.domain.Status;
import com.techm.tasks.domain.Task;
import com.techm.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Optional<Task> getOneTask(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if(!taskOptional.isPresent()){
            throw new IllegalStateException("task id did not find");
        }

        return taskOptional;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> taskByUserId(Long userId) {
        return taskRepository.findByIdUser(userId);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Long taskId, Task newTask) {

        Task existTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "task whith id " + taskId + "does not exist"));

        if(newTask.getDescription() != null &&
                newTask.getDescription().length() > 0 &&
                !Objects.equals(existTask.getDescription(), newTask.getDescription())){
            existTask.setDescription(newTask.getDescription());
        }

        if(newTask.getStatus() != null &&
                !Objects.equals(existTask.getStatus(), newTask.getStatus())){
            existTask.setStatus(newTask.getStatus());
        }

        if(newTask.getIdUser() != null && newTask.getIdUser() != 0){
            existTask.setIdUser(newTask.getIdUser());
        }

        taskRepository.save(existTask);
    }

    @Override
    public void deleteById(Long taskId) {
        boolean taskExist = taskRepository.existsById(taskId);
        if(!taskExist){
            throw new IllegalStateException("tasks whit id " + taskId + "does not exist");
        }
        taskRepository.deleteById(taskId);
    }
}
