package com.prakash.toDoList.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prakash.toDoList.domain.model.Todo;
import com.prakash.toDoList.domain.service.TodoService;

@Controller
@RequestMapping("todo")

public class TodoController {

	@Autowired
	 TodoService todoService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@ModelAttribute
	public Todo setupForm() {
		Todo form = new Todo();
		return form;
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Todo> todos = todoService.findAll();
		model.addAttribute("todos", todos);
		return "todo/list";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String create(@ModelAttribute("todoForm") TodoForm todoForm) {
//				
		Todo todo = modelMapper.map(todoForm,  Todo.class );
		
		todoService.create(todo);
		
		return "redirect:list";
	}
	
	@PostMapping("/finish/{id}")
	public String finishTodo(@PathVariable String id) {
	    todoService.finish(id);
	    return "redirect:/todo/list";
	}

	@GetMapping("/edit/{id}")
	public String editTodoForm(@PathVariable String id, Model model) {
	    Todo todo = todoService.findOne(id);
	    model.addAttribute("todo", todo);
	    return "todo/todo-edit";
	}

	@PostMapping("/update")
	public String updateTodo(
	        @RequestParam("id") String todoId,
	        @RequestParam("todoTitle") String todoTitle,
	        @RequestParam("finished") boolean finished) {
	    todoService.updateTodo(todoId, todoTitle, finished);
	    return "redirect:/todo/list";
	}




	
}
