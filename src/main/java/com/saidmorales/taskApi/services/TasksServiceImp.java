package com.saidmorales.taskApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saidmorales.taskApi.model.Task;
import com.saidmorales.taskApi.repository.TasksRepository;

@Service
public class TasksServiceImp implements TasksService {

	@Autowired
	private TasksRepository taskRepository;
		
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	public Task findById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		
		if (task.isPresent()) {
			return task.get();
		} else {
			return null;
		}
	}
	public Task save(Task task) {
		return taskRepository.save(task);
		
	}
	
	public void delete(Long id)  {
		taskRepository.deleteById(id);
		
	}	
		
}

	

