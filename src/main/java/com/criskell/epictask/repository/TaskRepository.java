package com.criskell.epictask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criskell.epictask.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
