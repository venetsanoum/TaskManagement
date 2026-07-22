package com.example.task_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.task_management.entities.User;
import com.example.task_management.repositories.UserRepository;
import com.example.task_management.security.JWTService;

@Service
public class AuthService {
    private UserRepository repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthService(UserRepository repo){
        this.repo = repo;
    }

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword())); // hash password
        return repo.save(user);
    }

    public String verify(User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "Fail";
    }
}
