package com.prakash.toDoList.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.toDoList.domain.model.Todo;
import com.prakash.toDoList.domain.repository.TodoRepository;
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo findOne(String todoId) {
		
		Optional<Todo> optionalTodo = todoRepository.findById(todoId);
		Todo todo = optionalTodo.orElseThrow(()->new RuntimeException (" Todo not found with Id: " + todoId));
		
		return todo;
	}
	
	public List<Todo> findAll() {
		return todoRepository.findAll();
		
	}
	
	public Todo create(Todo todo) {
		String todoId = UUID.randomUUID().toString();
		Date createdAt = new Date();
		
		todo.setTodoId(todoId);
		todo.setCreatedAt(createdAt);
		todo.setFinished(false);
		todoRepository.save(todo);
	
		return todo;
	}
	

	
	public void updateTodo(String todoId, String todoTitle, boolean finished) {
		Optional<Todo> optionalTodo = todoRepository.findById(todoId);
		Todo todo = optionalTodo.orElseThrow(()->new RuntimeException (" Todo not found with Id: " + todoId));
        
        todo.setTodoTitle(todoTitle);
        todo.setFinished(finished);
        todoRepository.save(todo);
		
		
    }
	
	
	public Todo finish(String todoId) {
		Optional<Todo> optionalTodo = todoRepository.findById(todoId);
		Todo todo = optionalTodo.orElseThrow(()->new RuntimeException (" Todo not found with Id: " + todoId));
		todo.setFinished(true);
		todoRepository.save(todo);
		return todo;
	}
	
	public void delete(String todoId) {
		Optional<Todo> optionalTodo = todoRepository.findById(todoId);
		Todo todo = optionalTodo.orElseThrow(()->new RuntimeException (" Todo not found with Id: " + todoId));
		
		todoRepository.delete(todo);

}
}
