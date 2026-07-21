package com.example.task_management.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
   
    @RequestMapping("/")
    public String hello(){
        return "Welcome!";
    }
}
