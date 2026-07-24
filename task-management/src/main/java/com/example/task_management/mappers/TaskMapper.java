package com.example.task_management.mappers;

import com.example.task_management.dto.response.TaskResponse;
import com.example.task_management.entities.Task;

public class TaskMapper {
    public static TaskResponse toResponse(Task task){
        return TaskResponse.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .dueDate(task.getDueDate())
                        .status(task.getStatus())
                        .priority(task.getPriority())
                        .build();
    }
}
