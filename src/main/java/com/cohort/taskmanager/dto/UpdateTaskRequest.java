package com.cohort.taskmanager.dto;

import com.cohort.taskmanager.data.enums.TaskPriority;
import com.cohort.taskmanager.data.enums.TaskStatus;

public record UpdateTaskRequest(
        String taskId,
        String title,
        String description,
        TaskPriority taskPriority,
        TaskStatus taskStatus
) {
}
