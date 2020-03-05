package com.cts.training.stockpriceservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPriceServiceImpl implements StockPriceService{
	
	@Autowired
	StockPriceRepo stockpriceRepo;

	@Override
	public StockPrice insert(StockPrice stockPrice) {
		StockPrice stockprice=stockpriceRepo.save(stockPrice);
		return stockprice;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		stockpriceRepo.deleteById(id);
		
	}

	@Override
	public StockPrice update(StockPrice stockPrice) {
		StockPrice stockprice=stockpriceRepo.save(stockPrice);
		return stockprice;
	}

	@Override
	public StockPrice getStockPriceById(int id) {
		Optional<StockPrice> stockpriceList=stockpriceRepo.findById(id);
		StockPrice stockprice=stockpriceList.get();
		return stockprice;
	}

	@Override
	public List<StockPrice> getAllStockprices() {
		return stockpriceRepo.findAll();
	}
	

}
