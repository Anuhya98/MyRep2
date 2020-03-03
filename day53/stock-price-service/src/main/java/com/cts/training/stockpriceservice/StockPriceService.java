package com.cts.training.stockpriceservice;

import java.util.List;

public interface StockPriceService {
	
	public StockPrice insert(StockPrice stockPrice);
	public void delete(int id);
	public StockPrice update(StockPrice stockPrice);
	public StockPrice getStockPriceById(int id);
	public List<StockPrice> getAllStockprices();

}
