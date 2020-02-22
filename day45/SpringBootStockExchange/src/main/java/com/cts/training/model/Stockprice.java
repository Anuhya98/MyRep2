package com.cts.training.model;

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
@Table(name="stockprice")
public class Stockprice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2286347133270333564L;
	@Id
	@GeneratedValue
	private int companyId;
    private String stockExchange;
    private long currentPrice;
    private LocalDate date;
    private LocalTime time;
	
    public Stockprice() {
    	
    }
	public Stockprice(int companyId, String stockExchange, long currentPrice, LocalDate date, LocalTime time) {
		super();
		this.companyId = companyId;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
	
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public long getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentprice(long currentprice) {
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
		return "Stockprice [companyId=" + companyId + ", stockExchange=" + stockExchange + ", currentPrice="
				+ currentPrice + ", date=" + date + ", time=" + time + "]";
	}
	
	
    
}
