package com.example.task_management.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project title is required")
    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(
        name = "project_members",
        joinColumns = @JoinColumn(name="project_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;

    @ManyToOne
    @JoinColumn(name="created_by", nullable = false)
    private User createdBy;

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    List<Task> tasks;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    // run this before adding the record to the database
    @PrePersist
    public void PrePersist(){
        this.createdAt=LocalDateTime.now();
    }

}
