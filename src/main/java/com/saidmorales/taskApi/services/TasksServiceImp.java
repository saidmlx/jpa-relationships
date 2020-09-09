package com.saidmorales.taskApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saidmorales.taskApi.model.Tasks;
import com.saidmorales.taskApi.repository.TasksRepository;

@Service
public class TasksServiceImp implements TasksService {

	@Autowired
	private TasksRepository taskRepository;
		
	public List<Tasks> getAllTasks() {
		return taskRepository.findAll();
	}
		
}

	

