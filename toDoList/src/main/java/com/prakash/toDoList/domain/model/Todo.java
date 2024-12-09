package com.prakash.toDoList.domain.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Todo {

	@Id
	private String todoId;
	private String todoTitle;
	private boolean finished;
	private Date createdAt;
	
	
	public Todo() {
		super();
	}

	public Todo(String todoId, String todoTitle, boolean finished, Date createdAt) {
		super();
		this.todoId = todoId;
		this.todoTitle = todoTitle;
		this.finished = finished;
		this.createdAt = createdAt;
	}
	public String getTodoId() {
		return todoId;
	}
	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
