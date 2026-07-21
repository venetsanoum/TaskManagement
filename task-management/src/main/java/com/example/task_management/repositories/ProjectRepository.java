package com.example.task_management.repositories;
import com.example.task_management.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
