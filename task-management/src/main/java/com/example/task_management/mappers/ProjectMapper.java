package com.example.task_management.mappers;

import com.example.task_management.dto.response.ProjectResponse;
import com.example.task_management.entities.Project;

public class ProjectMapper {

    public static ProjectResponse toResponse(Project project){
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .createdBy(UserMapper.toResponse(project.getCreatedBy()))
                .members(
                    project.getMembers()
                            .stream()
                            .map(UserMapper::toResponse)
                            .toList()
                )   
                .build();
    }
}
