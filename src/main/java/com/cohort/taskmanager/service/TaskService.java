package com.cohort.taskmanager.service;

import com.cohort.taskmanager.data.mapper.TaskMapper;
import com.cohort.taskmanager.data.model.Task;
import com.cohort.taskmanager.data.repository.TaskRepository;
import com.cohort.taskmanager.dto.CreateTaskRequest;
import com.cohort.taskmanager.dto.TaskResponse;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponse createTask(CreateTaskRequest createTaskRequest) {
        Task task = taskMapper.toEntity(createTaskRequest);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toResponse(savedTask);
    }

    public TaskResponse getTask(String taskId){
        Task task = taskRepository.findByTaskId(taskId);
        return taskMapper.toResponse(task);
    }




}
