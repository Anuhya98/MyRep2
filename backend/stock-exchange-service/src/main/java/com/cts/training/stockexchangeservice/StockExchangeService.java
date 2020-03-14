package com.cts.training.stockexchangeservice;

import java.util.List;



public interface StockExchangeService {
	public StockExchange insert(StockExchange stockExchange);
	public void delete(int id);
	public StockExchange update(StockExchange stockExchange);
	public StockExchange getStockExchangeById(int id);
	public List<StockExchange> getAllStockExchanges();

}
