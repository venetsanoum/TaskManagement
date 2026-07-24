package com.example.task_management.dto.response;

import java.time.LocalDateTime;

import com.example.task_management.entities.Priority;

import com.example.task_management.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Priority priority;
    private Status status;
}
