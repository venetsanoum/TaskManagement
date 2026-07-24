package com.example.task_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_management.dto.request.UpdatedStatusRequest;
import com.example.task_management.dto.response.TaskResponse;
import com.example.task_management.entities.Task;
import com.example.task_management.services.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @PostMapping("/{id}")
    public TaskResponse createTask(@Valid @RequestBody Task task, @PathVariable Long id){
        return taskService.createTask(task, id);
    }
    @GetMapping("/{id}")
    public List<TaskResponse> getTasksOfProject(@PathVariable Long id){
        return taskService.getTasksOfProject(id);
    }
    @PutMapping("{id}")
    public TaskResponse updateTask(@Valid @RequestBody Task task, @PathVariable("id") Long id, @PathVariable("projectId") Long projectId){
        return taskService.createTask(task, id);
    }
    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
    }
    @PatchMapping("{id}/status")
    public TaskResponse updateStatus(@Valid @RequestBody UpdatedStatusRequest request, @PathVariable("id") Long id){
        return taskService.updateStatus(request.getStatus(), id);
    }

}
