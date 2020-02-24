package com.cts.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.model.User;
import com.cts.training.repo.UserRepo;

@CrossOrigin(origins="*")
@RestController
public class UserRestServiceController {
	@Autowired
	UserRepo ur;
	
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
	
	@PostMapping("/users")
	public User save(@RequestBody User usr) {
		User us = ur.save(usr);
		return us;
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		ur.deleteById(id);
	}
	
	@PutMapping("/users")
	public User update(@RequestBody User usr) {
		User us = ur.save(usr);
		return us;
	}


}
