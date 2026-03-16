package com.taskmanager.backend.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.backend.entity.User;



public interface  UserRepository extends JpaRepository<User, Long>{

    Optional<User>   findByUsername(String username);



}
