package com.in28Minutes.learning.restfulWebService.restfulwebservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name = "Todo")
public class Todo {
	
	@Id
	@Column(name= "task_id", nullable = false, unique = true)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
	@Column(name = "task_name", nullable = false)
	private String name;
	
	@Column(name = "target_date", nullable = false)
	@Temporal(TemporalType.DATE )
	private Date targetDate;
	
	@Column(name = "is_complete")
	private boolean isComplete;
	
	
	
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
	public Todo(int taskId, String name, Date targetDate, boolean isComplete) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.targetDate = targetDate;
		this.isComplete = isComplete;
		
	}
	
	public Todo() {
		
	}
	
}
