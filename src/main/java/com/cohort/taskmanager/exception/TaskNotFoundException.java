package com.cohort.taskmanager.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String taskId) {
        super("Task with id " + taskId + " not found");
    }
}
