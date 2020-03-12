package com.cts.training.stockexchangeservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?>getallstockexchanges() {
		List<StockExchange> list = stockexchangeService.getAllStockExchanges();
		if(list.size()>0)
		{
			return new ResponseEntity<List<StockExchange>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No stockexchanges found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/stockexchange/{id}")
	public ResponseEntity<?> getElementById(@PathVariable("id") int id) {
		try {
			StockExchange stockExchange=stockexchangeService.getStockExchangeById(id);
			return new ResponseEntity<StockExchange>(stockExchange,HttpStatus.OK);
		}catch(NoClassDefFoundError e){
			return new ResponseEntity<String>("No such stockexchage found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/stockexchange")
	public ResponseEntity<StockExchange> save(@RequestBody StockExchange stockExchange) {
		stockexchangeService.insert(stockExchange);
		return new ResponseEntity<StockExchange>(stockExchange,HttpStatus.OK);
	}
	
	@DeleteMapping("/stockexchange/{id}")
	public ResponseEntity<StockExchange> delete(@PathVariable int id) {
		stockexchangeService.delete(id);
		return new ResponseEntity<StockExchange>(HttpStatus.OK);
	}
	
	@PutMapping("/stockexchange")
	public ResponseEntity<StockExchange> update(@RequestBody StockExchange stockExchange) {
		stockexchangeService.update(stockExchange);
		return new ResponseEntity<StockExchange>(HttpStatus.OK);
	}

}
