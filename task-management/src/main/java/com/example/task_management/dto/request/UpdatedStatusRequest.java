package com.example.task_management.dto.request;

import com.example.task_management.entities.Status;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UpdatedStatusRequest {
    private Status status;
}
