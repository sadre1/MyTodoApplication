package com.example.Sadrealam.Springboot.MyexcersirePartOne.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoList {
	

	private static  List<Todo> todos= new ArrayList<>();
	
	static int todocounter=0;
//	static {
//		todos.add(new Todo(++todocounter,"sadrealam","Learning Spring Boot",LocalDate.now().plusYears(1),false));
//		todos.add(new Todo(++todocounter,"prashant","AI-ML",LocalDate.now().plusYears(1),false));
//		todos.add(new Todo(++todocounter,"kamni","Arduino Uno",LocalDate.now().plusYears(1),false));
//	}
	
	public List<Todo> findByUsername(String Username){
		return todos;

	}
	
	public void addTodo(String username , String description , LocalDate date , boolean done) {
		 Todo todo = new Todo(++todocounter,username,description,date,done);
		 todos.add(todo);
	}
	
	
	public void DeleteTodo(int id) {
		Predicate<? super Todo> Pradicate = todo->todo.getId()==id;
		todos.removeIf(Pradicate);
	}

	public Todo FindById(int id) {
		Predicate<? super Todo> Pradicate = todo->todo.getId()==id;
		Todo todo = todos.stream().filter(Pradicate).findFirst().get();
		return todo;
	}

	public void updatetodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		DeleteTodo(todo.getId());
		todos.add(todo);	
	}
	

}
