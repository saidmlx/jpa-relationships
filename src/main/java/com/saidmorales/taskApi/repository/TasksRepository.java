package com.saidmorales.taskApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saidmorales.taskApi.model.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
