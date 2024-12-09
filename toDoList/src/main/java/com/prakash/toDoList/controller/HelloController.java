package com.prakash.toDoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String getHello() {
		return "hello";
	}
	
	@GetMapping("/list")
	public String getList() {
		return "list";
	}
	
	
	

}
