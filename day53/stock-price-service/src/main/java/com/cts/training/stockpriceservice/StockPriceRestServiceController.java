package com.cts.training.stockpriceservice;

import java.util.List;
import java.util.NoSuchElementException;

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
public class StockPriceRestServiceController {
	
	@Autowired
	StockPriceService stockpriceService;
	
	@GetMapping("/stockprice")
	public List<StockPrice> findAll() {
		return stockpriceService.getAllStockprices();
	}
	
	@GetMapping("/stockprice/{id}")
	public StockPrice getStockPriceById(@PathVariable int id) throws NoSuchElementException
	{
		StockPrice stockpriceList=stockpriceService.getStockPriceById(id);
		return stockpriceList;
	}
	
	@PostMapping("/stockprice")
	public StockPrice save(@RequestBody StockPrice stockPrice) {
		StockPrice newStockprice=stockpriceService.insert(stockPrice);
		return newStockprice;
	}
	
	@DeleteMapping("/stockprice/{id}")
	public void delete(@PathVariable int id) {
		stockpriceService.delete(id);
	}
	
	@PutMapping("/updatestockprice")
	public StockPrice update(@RequestBody StockPrice stockPrice) {
		StockPrice updateStockprice=stockpriceService.update(stockPrice);
		return updateStockprice;
	}


}
