package com.saidmorales.taskApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saidmorales.taskApi.model.Task;

public interface TasksRepository extends JpaRepository<Task, Long> {

}
