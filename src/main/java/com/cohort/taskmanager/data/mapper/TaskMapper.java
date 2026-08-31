package com.cohort.taskmanager.data.mapper;

import com.cohort.taskmanager.data.model.Task;
import com.cohort.taskmanager.dto.CreateTaskRequest;
import com.cohort.taskmanager.dto.TaskResponse;
import com.cohort.taskmanager.utils.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {
    public Task toEntity(CreateTaskRequest createTaskRequest) {
        return new Task(createTaskRequest.title(),
                StringUtils.normalizeString(createTaskRequest.description()),
                createTaskRequest.taskPriority()
                );
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getTaskId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }

}
