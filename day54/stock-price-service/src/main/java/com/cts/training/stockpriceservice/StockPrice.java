package com.cts.training.stockpriceservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="stockpricebackend")
public class StockPrice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7008954115474183132L;
	
	@Id
	@GeneratedValue
	private int id;
    private String companyCode;
    private String stockExchange;
    private double currentPrice;
    private LocalDate date;
    private LocalTime time;
	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", companyCode=" + companyCode + ", stockExchange=" + stockExchange
				+ ", currentPrice=" + currentPrice + ", date=" + date + ", time=" + time + "]";
	}
    
    

}
