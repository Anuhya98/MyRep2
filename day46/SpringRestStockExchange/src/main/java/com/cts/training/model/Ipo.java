package com.cts.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ipobackend")
public class Ipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8552296413075904895L;
	
	@Id
	//@GeneratedValue
	private int id;
	private String companyname;
	private String stockexchange;
	private int pricepershare;
	private int totalnoofshares;
	public Ipo() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getStockexchange() {
		return stockexchange;
	}
	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
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
	@Override
	public String toString() {
		return "Ipo [id=" + id + ", companyname=" + companyname + ", stockexchange=" + stockexchange
				+ ", pricepershare=" + pricepershare + ", totalnoofshares=" + totalnoofshares + "]";
	}
	
	
}
