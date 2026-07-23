package com.example.task_management.dto.response;

import java.time.LocalDateTime;

import com.example.task_management.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private Role role;

    private LocalDateTime createdAt;
}