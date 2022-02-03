package com.techm.tasks.repository;

import com.techm.tasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository
        extends JpaRepository <Task, Long>{

}
