package com.example.task_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_management.services.ProjectService;
import com.example.task_management.dto.response.ProjectResponse;
import com.example.task_management.dto.response.UserResponse;
import com.example.task_management.entities.Project;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    /* POST /api/projects */
    @PostMapping
    public ProjectResponse createProject(@Valid @RequestBody Project project){
        return projectService.createProject(project);
    }
    /* PUT /api/projects/{id} */
    @PutMapping("/{id}")
    public ProjectResponse updateProject(@PathVariable Long id, @Valid @RequestBody Project project){
        return projectService.updateProject(id, project);
    }
    /* GET /api/projects */
    @GetMapping
    public List<ProjectResponse> getProjects(){
        return projectService.getProjects();
    }
    /* GET /api/projects/{id} */
    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }
    /* DELETE /api/projects/{id} */
    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable Long id){
        projectService.deleteProjectById(id);
    }
    /* GET /api/projects/{id}/members */
    @GetMapping("/{id}/members")
    public List<UserResponse> getProjectUsers(@PathVariable Long id){
        return projectService.getProjectUsers(id);
    }
    /* POST /api/projects/{id}/members/{userId} */
    @PostMapping("/{id}/members/{userId}")
    public UserResponse addMemberToProject(@PathVariable("id") Long id, @PathVariable("userId") Long userId){
        return projectService.addMemberToProject(id, userId);
    }
    /* DELETE /api/projects/{id}/members/{userId} */
    @DeleteMapping("/{id}/members/{userId}")
    public void deleteUserFromProject(@PathVariable("id") Long id, @PathVariable("userId") Long userId){
        projectService.deleteUserFromProject(id, userId);
    }
}
