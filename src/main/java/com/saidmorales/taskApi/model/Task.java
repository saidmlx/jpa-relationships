package com.saidmorales.taskApi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TASKS")
public class Task  implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRIORITY")
	private long priority;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "USERS_TASKS",
			joinColumns = @JoinColumn(name = "ID_TASK"),
			inverseJoinColumns = @JoinColumn(name = "ID_USER")
			)
	@JsonIgnore
	Set<User> users = new HashSet<>();;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
