package com.cohort.taskmanager.dto;

import com.cohort.taskmanager.data.enums.TaskPriority;
import com.cohort.taskmanager.data.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(
        String taskId,
        String title,
        String description,
        TaskPriority taskPriority,
        TaskStatus  taskStatus,
        LocalDateTime createdAt
) {
}
