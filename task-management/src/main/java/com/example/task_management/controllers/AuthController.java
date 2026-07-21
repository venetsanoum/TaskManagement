package com.example.task_management.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_management.entities.User;
import com.example.task_management.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }
}
