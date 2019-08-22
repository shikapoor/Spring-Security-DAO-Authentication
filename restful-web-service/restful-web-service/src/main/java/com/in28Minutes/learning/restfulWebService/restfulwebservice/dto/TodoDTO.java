package com.in28Minutes.learning.restfulWebService.restfulwebservice.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TodoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7690802445537312607L;
	private int taskId;
	private String name;
	private Date targetDate;
	
	@JsonProperty(value = "isComplete")
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
	public TodoDTO(int taskId, String name, Date targetDate, boolean isComplete) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.targetDate = targetDate;
		this.isComplete = isComplete;
		
	}
	
	public TodoDTO() {
		
	}
	
}
