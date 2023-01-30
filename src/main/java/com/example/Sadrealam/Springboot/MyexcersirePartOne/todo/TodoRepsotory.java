package com.example.Sadrealam.Springboot.MyexcersirePartOne.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepsotory extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);

}
