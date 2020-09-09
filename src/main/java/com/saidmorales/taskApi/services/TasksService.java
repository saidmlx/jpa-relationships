package com.saidmorales.taskApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saidmorales.taskApi.model.Tasks;
import com.saidmorales.taskApi.repository.TasksRepository;


public interface TasksService  {
	
	public List<Tasks> getAllTasks();
	
}
