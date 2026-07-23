package com.example.task_management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task_management.dto.response.UserResponse;
import com.example.task_management.entities.Project;
import com.example.task_management.entities.User;
import com.example.task_management.repositories.ProjectRepository;
import com.example.task_management.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    /* POST /api/projects */
    public Project createProject(Project project){
        return projectRepository.save(project);
    }
    /* PUT /api/projects/{id} */
    public Project updateProject(Long id, Project project){
        Project existingProject = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id " + id));

        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        return projectRepository.save(existingProject);
    }
    /* GET /api/projects */
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }
    /* GET /api/projects/{id} */
    public Project getProjectById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Project not found!"));
    }
    /* DELETE /api/projects/{id} */
    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }
    /* GET /api/projects/{id}/members */
    public List<UserResponse> getProjectUsers(Long id){
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));
        return project.getMembers()
        .stream()
        .map(user -> UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build())
        .toList();
    }
    /* POST /api/projects/{id}/members/{userid} */
    public UserResponse addMemberToProject(Long id, Long userId){
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found!"));
        project.getMembers().add(user);
        projectRepository.save(project);
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build();
    }
    /* DELETE /api/projects/{id}/members/{userId} */
    public void deleteUserFromProject(Long id, Long userId){
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found!"));
        project.getMembers().remove(user);
        projectRepository.save(project);
    }
}
