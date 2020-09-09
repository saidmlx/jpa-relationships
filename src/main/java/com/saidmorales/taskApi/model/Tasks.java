package com.saidmorales.taskApi.model;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
public class Tasks {
	
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRIORITY")
	private long priority;
	
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
	
	
}
