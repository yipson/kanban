package com.techm.tasks.bootstrap;

import com.techm.tasks.domain.Status;
import com.techm.tasks.domain.Task;
import com.techm.tasks.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
//public class TaskBootstrap {
//
//    @Bean
//    CommandLineRunner commandLineRunner(
//            TaskRepository repository){
//        return args -> {
//
//            Task task = new Task(
//                    "soy la tarea numero uno",
//                    Status.TO_DO
//            );
//
//            Task task2 = new Task(
//                    "soy la tarea numero uno",
//                    Status.IN_PROGRESS,
//                    1L
//            );
//
//            repository.saveAll(
//                    List.of(task, task2)
//            );
//        };
//    }
//}
