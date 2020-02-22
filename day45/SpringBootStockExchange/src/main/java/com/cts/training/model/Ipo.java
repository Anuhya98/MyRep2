package com.cts.training.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ipobackend")
public class Ipo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8124340549588970388L;
	@Id
	@GeneratedValue
	private int id;
	private String companyName;
	private String stockExchange;
	private int pricepershare;
	private int totalnoofshares;
	private LocalDateTime openDateTime;
	private String remarks;
	public Ipo() {
		
	}
	public Ipo(int id, String companyName, String stockExchange, int pricepershare, int totalnoofshares,
			LocalDateTime openDateTime, String remarks) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricepershare = pricepershare;
		this.totalnoofshares = totalnoofshares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public int getPricepershare() {
		return pricepershare;
	}
	public void setPricepershare(int pricepershare) {
		this.pricepershare = pricepershare;
	}
	public int getTotalnoofshares() {
		return totalnoofshares;
	}
	public void setTotalnoofshares(int totalnoofshares) {
		this.totalnoofshares = totalnoofshares;
	}
	public LocalDateTime getOpenDateTime() {
		return openDateTime;
	}
	public void setOpenDateTime(LocalDateTime openDateTime) {
		this.openDateTime = openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Ipo [id=" + id + ", companyName=" + companyName + ", stockExchange=" + stockExchange
				+ ", pricepershare=" + pricepershare + ", totalnoofshares=" + totalnoofshares + ", openDateTime="
				+ openDateTime + ", remarks=" + remarks + "]";
	}
	

}
