package com.cts.training.stockpriceservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.mail.Multipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins="*")
@RestController
public class StockPriceRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StockPriceService stockpriceService;
	
	@GetMapping("/stockprice")
	public ResponseEntity<?>getallstockprices() {
		List<StockPrice> list = stockpriceService.getAllStockprices();
		if(list.size()>0)
		{
			return new ResponseEntity<List<StockPrice>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No companies found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/stockprice/companyStockPriceBetween/{companyCode}/{stockExchange}/{startDate}/{endDate}", 
			produces = "application/json")
	public ResponseEntity<?> getCompanyStockPricePerDayBetween(@PathVariable String companyCode,
			@PathVariable String stockExchange, @PathVariable String startDate, @PathVariable String endDate) {
		return new ResponseEntity<List<StockPriceDaily>>(stockpriceService.getCompanyStockPriceBetween(companyCode,
				stockExchange, LocalDate.parse(startDate), LocalDate.parse(endDate)), HttpStatus.OK);
	}
	
	@GetMapping("/stockprice/{id}")
	public ResponseEntity<?> getElementById(@PathVariable("id") int id) {
		try {
			StockPrice stockPrice=stockpriceService.getStockPriceById(id);
			return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.OK);
		}catch(NoClassDefFoundError e){
			return new ResponseEntity<String>("No such company found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/stockprice")
	public ResponseEntity<StockPrice> save(@RequestBody StockPrice stockPrice) {
		stockpriceService.insert(stockPrice);
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.OK);
	}
	
	@DeleteMapping("/stockprice/{id}")
	public ResponseEntity<StockPrice> delete(@PathVariable int id) {
		stockpriceService.delete(id);
		return new ResponseEntity<StockPrice>(HttpStatus.OK);
	}
	
	@PutMapping("/stockprice")
	public ResponseEntity<StockPrice> update(@RequestBody StockPrice stockPrice) {
		stockpriceService.update(stockPrice);
		return new ResponseEntity<StockPrice>(HttpStatus.OK);
	}
	
	@PostMapping(value="stockprice/uploadStocksSheet",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadStocksSheet(@RequestParam("stocksSheet") MultipartFile file){
		logger.info("File Received:{}",file.getOriginalFilename());
		if(file.getOriginalFilename().endsWith(".xls")|| file.getOriginalFilename().endsWith(".xlsx")) {
			try {
				return new ResponseEntity<ImportSummary>(stockpriceService.addStockPricesFromExcelSheet(file),HttpStatus.OK);
			}
			catch(IOException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Error .Reading the file",HttpStatus.BAD_REQUEST);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return new ResponseEntity<String>("Wrong File selection.Only .xls and .xlsx file should be uploaded",HttpStatus.BAD_REQUEST);
		}
	}
	


}
