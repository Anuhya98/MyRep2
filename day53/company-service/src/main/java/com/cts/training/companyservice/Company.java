package com.cts.training.companyservice;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="companybackend")
public class Company implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8214322254449216974L;
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private int turnover;
	private String companyceoname;
	private String selectstockexchange;
	private String selectsector;
	private String aboutcompany;
	
	public Company() {
	
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

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	public String getCompanyceoname() {
		return companyceoname;
	}

	public void setCompanyceoname(String companyceoname) {
		this.companyceoname = companyceoname;
	}

	public String getSelectstockexchange() {
		return selectstockexchange;
	}

	public void setSelectstockexchange(String selectstockexchange) {
		this.selectstockexchange = selectstockexchange;
	}

	public String getSelectsector() {
		return selectsector;
	}

	public void setSelectsector(String selectsector) {
		this.selectsector = selectsector;
	}

	public String getAboutcompany() {
		return aboutcompany;
	}

	public void setAboutcompany(String aboutcompany) {
		this.aboutcompany = aboutcompany;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyname=" + companyname + ", turnover=" + turnover + ", companyceoname="
				+ companyceoname + ", selectstockexchange=" + selectstockexchange + ", selectsector=" + selectsector
				+ ", aboutcompany=" + aboutcompany + "]";
	}
	
	}

