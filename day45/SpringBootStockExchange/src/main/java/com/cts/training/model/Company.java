package com.cts.training.model;

import java.io.Serializable;
import java.time.LocalDate;

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
	private int idNumber;
	private String companyName;
	private String ceoName;
	private String boardMember;
	private int turnOver;
	private String briefDescription;
	private LocalDate ipoDate;
	
	public Company() {
	
	}
	public Company(int idNumber, String companyName, String ceoName, String boardMember, int turnOver,
			String briefDescription, LocalDate ipoDate) {
		super();
		this.idNumber = idNumber;
		this.companyName = companyName;
		this.ceoName = ceoName;
		this.boardMember = boardMember;
		this.turnOver = turnOver;
		this.briefDescription = briefDescription;
		this.ipoDate = ipoDate;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getBoardMember() {
		return boardMember;
	}
	public void setBoardMember(String boardMember) {
		this.boardMember = boardMember;
	}
	public int getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}
	public String getBriefDescription() {
		return briefDescription;
	}
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
	public LocalDate getIpoDate() {
		return ipoDate;
	}
	public void setIpoDate(LocalDate ipoDate) {
		this.ipoDate = ipoDate;
	}
	@Override
	public String toString() {
		return "Company [idNumber=" + idNumber + ", companyName=" + companyName + ", ceoName=" + ceoName
				+ ", boardMember=" + boardMember + ", turnOver=" + turnOver + ", briefDescription=" + briefDescription
				+ ", ipoDate=" + ipoDate + "]";
	}
	

}
