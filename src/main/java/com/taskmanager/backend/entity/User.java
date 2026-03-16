package com.taskmanager.backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false , unique=true)
    private String username;

    @Column(nullable=false)
    private String password;

    public User(){

    }
public User(String username,String password){
    //service layer
    this.username=username;         
    this.password=password;
}
public long getId(){
    return id;
}
public String getUsername(){
    return username;
}
public String getPassword(){
    return password;
}
public void setUsername(String username){
    this.username=username;
}
public void setPassword(String password){
    this.password=password;
}

@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
@JsonManagedReference
private List<Task> tasks;
}