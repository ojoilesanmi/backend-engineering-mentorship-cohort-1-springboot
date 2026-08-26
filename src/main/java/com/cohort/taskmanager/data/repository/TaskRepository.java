package com.cohort.taskmanager.data.repository;

import com.cohort.taskmanager.data.enums.TaskPriority;
import com.cohort.taskmanager.data.enums.TaskStatus;
import com.cohort.taskmanager.data.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
    Page<Task> findByPriority(TaskPriority priority, Pageable pageable);
    Page<Task> findByStatusAndPriority(TaskStatus status, TaskPriority priority, Pageable pageable);
}
