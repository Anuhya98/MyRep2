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

import com.cts.training.model.Ipo;
import com.cts.training.repo.IpoRepo;

@CrossOrigin(origins="*")
@RestController
public class IpoRestServiceController {
	@Autowired
	IpoRepo ir;
	
	@GetMapping("/ipos")
	public List<Ipo> findAll() {
		return ir.findAll();
	}
	
	@GetMapping("/ipos/{id}")
	public Ipo findOne(@PathVariable int id) {
		Optional<Ipo> iPO = ir.findById(id);
		Ipo i = iPO.get();
		return i;
	}
	
	@PostMapping("/ipos")
	public Ipo save(@RequestBody Ipo iPO) {
		Ipo i=ir.save(iPO);
		return i;
	}
	
	@DeleteMapping("/ipos/{id}")
	public void delete(@PathVariable int id) {
		ir.deleteById(id);
	}
	
	@PutMapping("/updateipos")
	public Ipo update(@RequestBody Ipo iPO) {
		Ipo i=ir.save(iPO);
		return i;
	}


}
