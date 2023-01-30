package com.example.Sadrealam.Springboot.MyexcersirePartOne.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	//http://localhost:8080/login
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.put("name",getNameAuthentication());
		return "welcome";
	}
     private String getNameAuthentication() {
    	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	  
    	  return authentication.getName();
     }
}
