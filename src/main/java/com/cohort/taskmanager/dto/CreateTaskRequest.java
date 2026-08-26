package com.cohort.taskmanager.dto;

import com.cohort.taskmanager.data.enums.TaskPriority;

public record CreateTaskRequest(
        String title,
        String description,
        TaskPriority taskPriority
) {
}
