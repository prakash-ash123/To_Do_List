package com.prakash.toDoList.controller;

public class TodoForm {
	
	private String todoTitle;
	
	

	public TodoForm(String todoTitle) {
		super();
		this.todoTitle = todoTitle;
	}

	public String getTodoTitle() {
		return todoTitle;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	
	

}
