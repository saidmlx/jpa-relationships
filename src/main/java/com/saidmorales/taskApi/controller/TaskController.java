package com.saidmorales.taskApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saidmorales.taskApi.model.Tasks;
import com.saidmorales.taskApi.services.TasksService;



@RestController
public class TaskController {

	
	private TasksService tasksService;
	public TaskController(TasksService tasksService) {
		this.tasksService = tasksService;
	}
	
	@GetMapping( "/tasks" )
	public ResponseEntity< List<Tasks>> getTasks() {
		return new ResponseEntity<>( tasksService.getAllTasks(), HttpStatus.OK );
	}
}
