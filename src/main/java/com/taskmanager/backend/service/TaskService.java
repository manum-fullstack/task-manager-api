package com.taskmanager.backend.service;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.taskmanager.backend.entity.Task;
import com.taskmanager.backend.entity.TaskStatus;
import com.taskmanager.backend.entity.User;
import com.taskmanager.backend.repository.TaskRepository;
import com.taskmanager.backend.repository.UserRepository;
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(Long userid, Task task){
        Optional<User> userOptional = userRepository.findById(userid);

        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }

        task.setUser(userOptional.get());

        return taskRepository.save(task);
    }

    public Page<Task> getTasksByUser(Long userid,Pageable pageable){
        return taskRepository.findByUserId(userid,pageable);
    }

    public void deleteTask(Long taskid) {
        taskRepository.deleteById(taskid);
    }

    public Task updateTask(Long taskid, Task updatedTask) {
        Task task=taskRepository.findById(taskid)
        .orElseThrow(() ->new
        RuntimeException("Task Not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());

        return taskRepository.save(task);
    }


    public Task getTaskById(Long taskid) {
        return taskRepository.findById(taskid)
        .orElseThrow(() ->new RuntimeException("Task not found")
        );
    }
    public Page<Task> getTasksByUsername(String username , Pageable pageable){

        User user=userRepository.findByUsername(username)
        .orElseThrow(() ->new RuntimeException("User not found"));
        return taskRepository.findAll(pageable);
    }
   public Task markTaskCompleted(Long taskid) {

    Task task = taskRepository.findById(taskid)
            .orElseThrow(() -> new RuntimeException("Task not found"));

    task.setStatus(TaskStatus.COMPLETED);

    return taskRepository.save(task);
}
   public List<Task> getTasksByStatus(TaskStatus status){
    return taskRepository.findByStatus(status);
   } 
}