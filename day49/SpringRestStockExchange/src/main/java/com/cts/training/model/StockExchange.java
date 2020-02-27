package com.cts.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="stockexchangebackend")
public class StockExchange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6053165027002285797L;
	@Id
	@GeneratedValue
	private int id;
	private String stockexchange;
	private String brief;
	private String contactaddress;
	private String remarks;
	public StockExchange() {
		
	}
	public StockExchange(int id, String stockexchange, String brief, String contactaddress, String remarks) {
		super();
		this.id = id;
		this.stockexchange = stockexchange;
		this.brief = brief;
		this.contactaddress = contactaddress;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockexchange() {
		return stockexchange;
	}
	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockexchange=" + stockexchange + ", brief=" + brief + ", contactaddress="
				+ contactaddress + ", remarks=" + remarks + "]";
	}
	
	
}
