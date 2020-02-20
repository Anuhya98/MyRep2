package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLogin(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
		public String showWelcome(@RequestParam String nm,ModelMap model) {
			model.put("name", nm);
			return "welcome";
		}
}


