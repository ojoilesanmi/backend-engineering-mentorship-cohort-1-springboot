package com.cohort.taskmanager.service;

import com.cohort.taskmanager.data.enums.TaskPriority;
import com.cohort.taskmanager.data.enums.TaskStatus;
import com.cohort.taskmanager.data.mapper.TaskMapper;
import com.cohort.taskmanager.data.model.Task;
import com.cohort.taskmanager.data.repository.TaskRepository;
import com.cohort.taskmanager.dto.CreateTaskRequest;
import com.cohort.taskmanager.dto.TaskResponse;
import com.cohort.taskmanager.dto.UpdateTaskRequest;
import com.cohort.taskmanager.exception.TaskNotFoundException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return taskMapper.toResponse(findTask(taskId));
    }

    public Page<TaskResponse> getTasks(TaskStatus status, TaskPriority priority, Pageable pageable) {
        Page<Task> tasks;

        if(status != null && priority != null) {
            tasks = taskRepository.findByStatusAndPriority(status, priority, pageable);
        } else if( status != null) {
            tasks = taskRepository.findByStatus(status, pageable);
        } else if( priority != null) {
            tasks = taskRepository.findByPriority(priority, pageable);
        } else {
            tasks = taskRepository.findAll(pageable);
        }
         return tasks.map(taskMapper::toResponse);
    }

    public TaskResponse updateTaskStatus(UpdateTaskRequest updateTaskRequest) {
        Task task = findTask(updateTaskRequest.taskId());

        if(updateTaskRequest.title() != null && !updateTaskRequest.title().isEmpty()) {
            String title = updateTaskRequest.title().trim();
            task.setTitle(title);
        }

        return null;

        //TODO
    }

    public void deleteTask(String taskId) {
        Task task = findTask(taskId);
        taskRepository.delete(task);
    }

    private Task findTask(String taskId){
        return taskRepository.findByTaskId(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }
}
