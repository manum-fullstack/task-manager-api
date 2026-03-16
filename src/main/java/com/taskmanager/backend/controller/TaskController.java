package com.taskmanager.backend.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.backend.entity.Task;
import com.taskmanager.backend.entity.TaskStatus;
import com.taskmanager.backend.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping("/{userid}/tasks")
    public Task createTask(@PathVariable Long userid ,@Valid @RequestBody Task task) {
        
        
        return taskService.createTask(userid,task);
    }
    @GetMapping("/{userid}/tasks")
    public Page<Task> getTasksByUser(@PathVariable Long userid,Pageable pageable){
        return taskService.getTasksByUser(userid,pageable);
    }
    @DeleteMapping("/tasks/{taskid}")
    public String deleteTask(@PathVariable Long taskid){
        taskService.deleteTask(taskid);
        return "Task Successfully Deleted";
    }
    @PutMapping("/tasks/{taskid}")
    public Task updateTask(@PathVariable Long taskid, @RequestBody Task updatedTask ) {

        return taskService.updateTask(taskid,updatedTask);
       }
   
    @GetMapping("/tasks/{taskid}")
    public Task getTaskById(@PathVariable Long taskid) {
        return taskService.getTaskById(taskid);
    }
    
    @GetMapping("/tasks")
    public Page<Task> getAllTasks(Pageable pageable){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        return taskService.getTasksByUsername(username,pageable);
    }
    @PutMapping("/tasks/{taskid}/complete")
public Task markTaskCompleted(@PathVariable Long taskid) {
    return taskService.markTaskCompleted(taskid);
}
    @GetMapping("/tasks/status/{status}")
public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
    return taskService.getTasksByStatus(status);
}
}
