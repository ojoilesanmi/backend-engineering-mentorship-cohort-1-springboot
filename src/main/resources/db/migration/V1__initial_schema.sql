create TABLE  tasks (
    id BIGINT PRIMARY KEY,
    task_id VARCHAR(150) NOT NUll,
    title VARCHAR(150) NOT NUll,
    description TEXT,
    status VARCHAR(30) NOT NUll,
    priority VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NUll,
    updated_at TIMESTAMP NOT NUll
);

CREATE INDEX idx_task_id
    ON tasks(task_id);
CREATE INDEX idx_tasks_status
    ON tasks(status);
CREATE INDEX idx_tasks_priority
    ON tasks(priority);
