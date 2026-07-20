package com.example.task_management.entities;

import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
enum Role {
    ADMIN,
    MEMBER
}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    @NotBlank(message = "Username is required")
    private String username;

    @Column(nullable=false)
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Email is required")
    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role is required")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "assignee")
    List<Task> assignedTasks;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void PrePersist(){
        this.createdAt=LocalDateTime.now();
    }

}
