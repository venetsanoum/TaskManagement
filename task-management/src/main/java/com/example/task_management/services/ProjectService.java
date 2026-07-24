package com.example.task_management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task_management.dto.response.ProjectResponse;
import com.example.task_management.dto.response.UserResponse;
import com.example.task_management.entities.Project;
import com.example.task_management.entities.User;
import com.example.task_management.mappers.ProjectMapper;
import com.example.task_management.mappers.UserMapper;
import com.example.task_management.repositories.ProjectRepository;
import com.example.task_management.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    /* POST /api/projects */
    public ProjectResponse createProject(Project project){
        Project saved = projectRepository.save(project);
        return ProjectMapper.toResponse(saved);
    }
    /* PUT /api/projects/{id} */
    public ProjectResponse updateProject(Long id, Project project){
        Project existingProject = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id " + id));

        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        Project updated = projectRepository.save(existingProject);
        return ProjectMapper.toResponse(updated);
    }
    /* GET /api/projects */
    public List<ProjectResponse> getProjects(){
        return projectRepository.findAll()
                                .stream()
                                .map(ProjectMapper::toResponse)
                                .toList();
    }
    /* GET /api/projects/{id} */
    public ProjectResponse getProjectById(Long id){
        Project found = projectRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Project not found!"));
        return ProjectMapper.toResponse(found);
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
        .map(UserMapper::toResponse)
        .toList();
    }
    /* POST /api/projects/{id}/members/{userid} */
    public UserResponse addMemberToProject(Long id, Long userId){
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found!"));
        project.getMembers().add(user);
        projectRepository.save(project);
        return UserMapper.toResponse(user);
    }
    /* DELETE /api/projects/{id}/members/{userId} */
    public void deleteUserFromProject(Long id, Long userId){
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found!"));
        project.getMembers().remove(user);
        projectRepository.save(project);
    }
}
