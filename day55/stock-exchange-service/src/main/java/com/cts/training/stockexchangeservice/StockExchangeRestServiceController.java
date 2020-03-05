package com.cts.training.stockexchangeservice;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*")
@RestController
public class StockExchangeRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StockExchangeService stockexchangeService;
	
	@GetMapping("/stockexchange")
	public List<StockExchange> findAll() {
		return stockexchangeService.getAllStockExchanges();
	}
	
	@GetMapping("/stockexchange/{id}")
	public StockExchange getIpoById(@PathVariable int id) throws NoSuchElementException
	{
	   StockExchange stockexchangeList=stockexchangeService.getStockExchangeById(id);
		return stockexchangeList;
	}
	
	@PostMapping("/stockexchange")
	public StockExchange save(@RequestBody StockExchange stockExchange) {
		StockExchange newStockexchange=stockexchangeService.insert(stockExchange);
		return newStockexchange;
	}
	
	@DeleteMapping("/stockexchange/{id}")
	public void delete(@PathVariable int id) {
		stockexchangeService.delete(id);
	}
	
	@PutMapping("/updatestockexchange")
	public StockExchange update(@RequestBody StockExchange stockExchange) {
		StockExchange updateStockexchange=stockexchangeService.update(stockExchange);
		return updateStockexchange;
	}

}
