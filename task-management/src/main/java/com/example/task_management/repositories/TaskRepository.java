package com.example.task_management.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.task_management.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
