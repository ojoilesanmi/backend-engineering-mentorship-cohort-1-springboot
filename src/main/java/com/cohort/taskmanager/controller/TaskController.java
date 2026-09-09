package com.cohort.taskmanager.controller;


import com.cohort.taskmanager.data.enums.TaskPriority;
import com.cohort.taskmanager.data.enums.TaskStatus;
import com.cohort.taskmanager.dto.CreateTaskRequest;
import com.cohort.taskmanager.dto.TaskResponse;
import com.cohort.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request){
        TaskResponse taskResponse = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> getAllTasks(@RequestParam(required = false)TaskStatus status,
                                                          @RequestParam(required = false)TaskPriority priority,
                                                          Pageable pageable) {
        return ResponseEntity.ok(taskService.getTasks(status, priority, pageable));
    }
}
