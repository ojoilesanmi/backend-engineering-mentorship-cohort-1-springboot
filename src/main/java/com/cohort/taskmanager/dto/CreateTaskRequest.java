package com.cohort.taskmanager.dto;

import com.cohort.taskmanager.data.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;


public record CreateTaskRequest(
        @NotBlank
        String title,
        String description,
        TaskPriority taskPriority
) {
}
