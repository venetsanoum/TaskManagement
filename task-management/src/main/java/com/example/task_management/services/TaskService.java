package com.example.task_management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task_management.dto.response.TaskResponse;
import com.example.task_management.entities.Project;
import com.example.task_management.entities.Status;
import com.example.task_management.entities.Task;
import com.example.task_management.mappers.TaskMapper;
import com.example.task_management.repositories.ProjectRepository;
import com.example.task_management.repositories.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    public TaskResponse createTask(Task task, Long id){
        Project proj = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));
        task.setProject(proj);
        Task saved = taskRepository.save(task);
        return TaskMapper.toResponse(saved);
    }
    public List<TaskResponse> getTasksOfProject(Long id){
        Project proj = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found!"));

        return proj.getTasks()
        .stream()
        .map(TaskMapper::toResponse)
        .toList();
    }
    public TaskResponse updateTask(Task task, Long id){
       Task existingTask = taskRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        existingTask.setAssignee(task.getAssignee());
        Task updated = taskRepository.save(existingTask);
        return TaskMapper.toResponse(updated);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public TaskResponse updateStatus(Status status, Long id){
        Task existingTask = taskRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setStatus(status);
        Task updated = taskRepository.save(existingTask);
        return TaskMapper.toResponse(updated);
    }
}
