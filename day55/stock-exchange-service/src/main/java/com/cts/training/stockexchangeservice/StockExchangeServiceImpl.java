package com.cts.training.stockexchangeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockExchangeServiceImpl implements StockExchangeService{
	
	@Autowired
	StockExchangeRepo stockexchangeRepo;

	@Override
	public StockExchange insert(StockExchange stockExchange) {
		StockExchange stockexchange=stockexchangeRepo.save(stockExchange);
		return stockexchange;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		stockexchangeRepo.deleteById(id);
		
	}

	@Override
	public StockExchange update(StockExchange stockExchange) {
		StockExchange stockexchange=stockexchangeRepo.save(stockExchange);
		return stockexchange;
	}

	@Override
	public StockExchange getStockExchangeById(int id) {
		Optional<StockExchange> stockexchangeList=stockexchangeRepo.findById(id);
		StockExchange se=stockexchangeList.get();
		return se;
	}

	@Override
	public List<StockExchange> getAllStockExchanges() {
		// TODO Auto-generated method stub
		return stockexchangeRepo.findAll();
	}

}
