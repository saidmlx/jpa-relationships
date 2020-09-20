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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.saidmorales.taskApi.model.User;
import com.saidmorales.taskApi.services.UserService;



@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users/v1")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	

	
	@GetMapping( "/user/v1/{id}" )
	public ResponseEntity< User > getUsers(@PathVariable("id") Long id  ) {
		User user  = userService.findById(id);
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping( "/user/v1"  )
	public ResponseEntity< User> getUsers(@RequestBody User User) {
		User userSaved = userService.save(User);
		if(userSaved != null) {
			return new ResponseEntity<User>(userSaved, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping( "/user/v1/{id}"  )
	public ResponseEntity< User> getUsers(@PathVariable("id") Long id, @RequestBody User User) {
		User UserSaved = userService.findById(id);
		if(UserSaved != null) {
			User UserUpdated = userService.save(User);
			if(UserUpdated != null) {
				return new ResponseEntity<User>(UserUpdated, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping( "/user/v1/{id}"  )
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		User UserSaved = userService.findById(id);
		if(UserSaved != null) {
			userService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
