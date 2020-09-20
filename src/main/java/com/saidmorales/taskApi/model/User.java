package com.saidmorales.taskApi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERS")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(mappedBy = "users")
	Set<Task> tasks= new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
