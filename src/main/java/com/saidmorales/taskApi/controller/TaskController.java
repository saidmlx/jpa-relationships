package com.saidmorales.taskApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saidmorales.taskApi.model.Task;
import com.saidmorales.taskApi.services.TasksService;



@RestController
public class TaskController {

	
	private TasksService tasksService;
	
	public TaskController(TasksService tasksService) {
		this.tasksService = tasksService;
	}
	
	@GetMapping( "/tasks" )
	public ResponseEntity< List<Task>> getTasks() {
		return new ResponseEntity<>( tasksService.getAllTasks(), HttpStatus.OK );
	}
	
	@GetMapping( "/task/{id}" )
	public ResponseEntity< Task> getTasks(@PathVariable("id") Long id  ) {
		Task task = tasksService.findById(id);
		if(task != null) {
			return new ResponseEntity<Task>(task, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping( "/task"  )
	public ResponseEntity< Task> getTasks(@RequestBody Task task) {
		Task taskSaved = tasksService.save(task);
		if(taskSaved != null) {
			return new ResponseEntity<Task>(taskSaved, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping( "/task/{id}"  )
	public ResponseEntity< Task> getTasks(@PathVariable("id") Long id, @RequestBody Task task) {
		Task taskSaved = tasksService.findById(id);
		if(taskSaved != null) {
			Task taskUpdated = tasksService.save(task);
			if(taskUpdated != null) {
				return new ResponseEntity<Task>(taskUpdated, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping( "/task/{id}"  )
	public ResponseEntity<Task> deleteTask(@PathVariable("id") Long id) {
		Task taskSaved = tasksService.findById(id);
		if(taskSaved != null) {
			tasksService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
