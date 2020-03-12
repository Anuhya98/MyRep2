package com.cts.training.stockpriceservice;

import java.time.LocalDate;

public class StockPriceDaily {
	private String companyCode;
	private String stockExchange;
	private String dataPoint;
	private double dataValue;
	public StockPriceDaily() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockPriceDaily(String companyCode, String stockExchange, String dataPoint, double dataValue) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.dataPoint = dataPoint;
		this.dataValue = dataValue;
	}
	public StockPriceDaily(String companyCode, String stockExchange, LocalDate dataPoint, double dataValue) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.dataPoint = dataPoint.toString();
		this.dataValue = dataValue;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getDataPoint() {
		return dataPoint;
	}
	public void setDataPoint(String dataPoint) {
		this.dataPoint = dataPoint;
	}
	public double getDataValue() {
		return dataValue;
	}
	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}
	@Override
	public String toString() {
		return "StockPriceDaily [companyCode=" + companyCode + ", stockExchange=" + stockExchange + ", dataPoint="
				+ dataPoint + ", dataValue=" + dataValue + "]";
	}
	

}
