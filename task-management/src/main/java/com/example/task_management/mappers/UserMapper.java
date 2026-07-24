package com.example.task_management.mappers;

import com.example.task_management.dto.response.UserResponse;
import com.example.task_management.entities.User;

public class UserMapper {
    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
