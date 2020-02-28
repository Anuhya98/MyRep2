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

import com.cts.training.model.StockExchange;
import com.cts.training.repo.StockExchangeRepo;

@RestController
@CrossOrigin(origins="*")
public class StockExchangeRestServiceController {
	@Autowired
	StockExchangeRepo ser;
	
	@GetMapping("/stockexchanges")
	public List<StockExchange> findAll() {
		return ser.findAll();
	}
	
	@GetMapping("/stockexchanges/{id}")
	public StockExchange findOne(@PathVariable int id) {
		Optional<StockExchange> ste = ser.findById(id);
		StockExchange se = ste.get();
		return se;
	}
	
	@PostMapping("/stockexchanges")
	public StockExchange save(@RequestBody StockExchange ste) {
		StockExchange se = ser.save(ste);
		return se;
	}
	
	@DeleteMapping("/stockexchanges/{id}")
	public void delete(@PathVariable int id) {
		ser.deleteById(id);
	}
	
	@PutMapping("/updatestockexchanges")
	public StockExchange update(@RequestBody StockExchange ste) {
		StockExchange se = ser.save(ste);
		return se;
	}
	

}
