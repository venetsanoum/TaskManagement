package com.example.task_management.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message="Task title is required")
    private String title;

    @Column
    private String description;

    @Column(name = "due_date", nullable = false)
    @NotNull(message = "Due date is required")
    private LocalDateTime dueDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Priority is required")
    private Priority priority;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status is required")
    private Status status;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="assignee_id")
    private User assignee;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void PrePersist(){
        this.createdAt=LocalDateTime.now();
    }


}
