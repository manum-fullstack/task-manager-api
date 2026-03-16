package com.taskmanager.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskmanager.backend.entity.User;
import com.taskmanager.backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User registerUser(User user) {

    Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

    if (existingUser.isPresent()) {
        throw new RuntimeException("Username already exists");
    }

    return userRepository.save(user);
}

public User updateUser(Long id, User updatedUser) {

    User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    existingUser.setUsername(updatedUser.getUsername());
    existingUser.setPassword(updatedUser.getPassword());

    return userRepository.save(existingUser);
}

    public void deleteUser(Long id) {

        User existingUser=userRepository.findById(id)
        .orElseThrow(() ->new  RuntimeException("User not found"));

        userRepository.delete(existingUser);
        
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

        public User getUserById(Long id){
            return userRepository.findById(id)
            .orElseThrow(() -> new  RuntimeException("User not found"));
        }
}
