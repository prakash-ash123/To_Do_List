package com.prakash.toDoList.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prakash.toDoList.domain.model.Todo;

public interface TodoRepository extends JpaRepository <Todo , String> {

}
