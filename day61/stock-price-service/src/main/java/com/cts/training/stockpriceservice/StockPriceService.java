package com.cts.training.stockpriceservice;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StockPriceService {
	
	public StockPrice insert(StockPrice stockPrice);
	public void delete(int id);
	public StockPrice update(StockPrice stockPrice);
	public StockPrice getStockPriceById(int id);
	public List<StockPrice> getAllStockprices();
	public ImportSummary addStockPricesFromExcelSheet(MultipartFile file) throws Exception;
	public List<StockPriceDaily> getCompanyStockPriceBetween(String companyCode, String stockExchange, LocalDate parse,
			LocalDate parse2);
	

}
