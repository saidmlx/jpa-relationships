package com.saidmorales.taskApi.services;

import java.util.List;
import com.saidmorales.taskApi.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User findById(Long id);
	public User save(User user);
	public void delete(Long id);
	
}
