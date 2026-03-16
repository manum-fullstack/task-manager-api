package com.taskmanager.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.backend.entity.Task;
import com.taskmanager.backend.entity.TaskStatus;


public interface  TaskRepository extends JpaRepository<Task, Long>{
    
    Page<Task> findByUserId(Long userid , Pageable pageable);

    List<Task> findByStatus(TaskStatus status);
}
