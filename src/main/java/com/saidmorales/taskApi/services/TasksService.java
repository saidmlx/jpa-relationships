package com.saidmorales.taskApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saidmorales.taskApi.model.Task;
import com.saidmorales.taskApi.repository.TasksRepository;


public interface TasksService  {
	
	public List<Task> getAllTasks();
	public Task findById(Long id);
	public Task save(Task task);
	public void delete(Long id);
	
}
