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

import com.cts.training.model.Company;
import com.cts.training.repo.CompanyRepo;

@CrossOrigin(origins="*")
@RestController
public class CompanyRestServiceController {
	@Autowired
	CompanyRepo cr;
	
	@GetMapping("/company")
	public List<Company> findAll() {
		return cr.findAll();
	}
	
	@GetMapping("/company/{id}")
	public Company findOne(@PathVariable int id) {
		Optional<Company> cmp = cr.findById(id);
		Company c = cmp.get();
		return c;
	}
	
	@PostMapping("/company")
	public Company save(@RequestBody Company cmp) {
		Company c=cr.save(cmp);
		return c;
	}
	
	@DeleteMapping("/company/{id}")
	public void delete(@PathVariable int id) {
		cr.deleteById(id);
	}
	
	@PutMapping("/updatecompany")
	public Company update(@RequestBody Company cmp) {
		Company c=cr.save(cmp);
		return c;
	}

}
