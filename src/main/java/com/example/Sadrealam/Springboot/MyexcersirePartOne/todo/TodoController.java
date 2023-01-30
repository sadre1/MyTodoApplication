package com.example.Sadrealam.Springboot.MyexcersirePartOne.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.Sadrealam.Springboot.MyexcersirePartOne.login.*;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoList todos;
	
	
//	http://localhost:8080/list_todos
	//list-todos
	@RequestMapping("/list-todos")
	public String goBackToTodo() {
		return"redirect:list_todos";
	}
	@RequestMapping("list_todos")
	public String todesbyusername(ModelMap model) {
              List<Todo> ts=todos.findByUsername("sadrealam");
              model.put("todos",ts);	
		return "todos";	
	}
	@RequestMapping(value="add-todo" , method=RequestMethod.GET)
	public String Shownewtodopage(ModelMap model) {
		String username= (String)model.get("name");
		Todo todo = new Todo(0,username,"TimePass",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";	
	}
	@RequestMapping(value="add-todo" , method=RequestMethod.POST)
	public String todoadded( ModelMap model ,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username= (String)model.get("name");
		todos.addTodo(username,todo.getDescription(),todo.getTargetdate(), false);
		return "redirect:list_todos";	
	}
	
	@RequestMapping("todo-delete")
	public String todeDelete(@RequestParam int id) {
		todos.DeleteTodo(id);
		return "redirect:list_todos";	
	}
	@RequestMapping(value="todo-update",method=RequestMethod.GET)
	public String todoShowUpdate(@RequestParam int id,ModelMap model) {
		Todo todo=todos.FindById(id);
		model.addAttribute("todo",todo);
		return "todo";	
	}
	@RequestMapping(value="todo-update" , method=RequestMethod.POST)
	public String addupdatetodo( ModelMap model ,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username= (String)model.get("name");
		todos.updatetodo(todo);
		return "redirect:list_todos";	
	}

}
