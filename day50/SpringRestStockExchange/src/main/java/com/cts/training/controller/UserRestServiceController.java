package com.cts.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.dto.UserDTO;
import com.cts.training.model.User;
import com.cts.training.repo.UserRepo;
import com.cts.training.service.UserService;

@CrossOrigin(origins="*")
@RestController
public class UserRestServiceController {
	@Autowired
	UserRepo ur;
	
	@Autowired
	UserService uss;
	
	@Autowired
	JavaMailSender jms;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return ur.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable int id) {
		Optional<User> usr = ur.findById(id);
		User us = usr.get();
		return us;
	}
	
//	@PostMapping("/users")
//	public User save(@RequestBody User usr) {
//		User us = .save(usr);
//		try {
//			SimpleMailMessage sm=new SimpleMailMessage();
//			sm.setFrom("anuhya1898@gmail.com");
//			sm.setTo(us.getEmail());
//			sm.setSubject("Testing mail");
//			sm.setText("Account created click on <a href='http://localhost:4200/activate?"+us.getEmail()+"'>Click</a>");
//			jms.send(sm);
//			System.out.println("sending mail...");
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
//		return us;
//	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		ur.deleteById(id);
	}
	
	@PutMapping("/users")
	public User update(@RequestBody User usr) {
		User us = ur.save(usr);
		return us;
	}
	
	@RequestMapping(value="/usersreg",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String reg() {
		
		return "{\"users\":\"ok\"}";
	}
	
	@PutMapping(value="/users/activate")
	public String activateUser(@RequestBody String e) {
		String temp = e.split(":")[1];
		String email=temp.split("\"")[1];
		User user = ur.findByEmail(email);
		if(user.getActive().equals("no")) {
			user.setActive("yes");
			ur.save(user);
			return "{\"result\":\"1\"}";
		}
		else
		return "{\"result\":\"0\"}";
		
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String save(@RequestBody UserDTO userdto){
		UserDTO user;
		String usermail;
		try {
			SimpleMailMessage sm=new SimpleMailMessage();
			sm.setFrom("anuhya1898@gmail.com");
			sm.setTo(userdto.getEmail());
			usermail=userdto.getEmail();
			if(ur.findByEmail(usermail)!=null) {
				return "{\"res\":\"0\"}";
				}
			else {
				user=uss.insert(userdto);
				sm.setSubject("testing mail...");
				sm.setText("Account created click on 'http://localhost:4200/activate?" + user.getEmail()
						+ "'");
				jms.send(sm);
				System.out.println("sending mail...");
				return "{\"res\":\"1\"}";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "{\"res\":\"2\"}";
		}
			
		}
			
		
		}
	
	
	



