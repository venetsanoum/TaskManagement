package com.example.task_management.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.task_management.entities.User;
import com.example.task_management.repositories.UserRepository;

@Service
public class AuthService {
    private UserRepository repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public AuthService(UserRepository repo){
        this.repo = repo;
    }

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword())); // hash password
        return repo.save(user);
    }
}
