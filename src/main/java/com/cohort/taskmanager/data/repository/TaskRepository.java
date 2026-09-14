package com.cohort.taskmanager.data.repository;

import com.cohort.taskmanager.data.enums.TaskPriority;
import com.cohort.taskmanager.data.enums.TaskStatus;
import com.cohort.taskmanager.data.model.Task;
import com.cohort.taskmanager.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
    Page<Task> findByPriority(TaskPriority priority, Pageable pageable);
    Page<Task> findByStatusAndPriority(TaskStatus status, TaskPriority priority, Pageable pageable);
    Optional<Task> findByTaskId(String taskId);
    Optional<Task> findByTaskIdAndOwner(String taskId, User owner);
    Page<Task> findByOwner(User owner, Pageable pageable);
    Page<Task> findByOwnerAndStatus(User owner, TaskStatus status, Pageable pageable);
    Page<Task> findByOwnerAndPriority(User owner, TaskPriority priority, Pageable pageable);
    Page<Task> findByOwnerAndStatusAndPriority(User owner, TaskStatus status, TaskPriority priority, Pageable pageable);

}
