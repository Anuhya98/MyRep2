package com.cts.training.userservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.CrossOrigin;


@Entity
@Table(name = "usersbackend")
//@XmlRootElement
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8817290365227430343L;
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String email;
	private long phoneno;
	private String password;
	private String confirmpassword;
	@Transient
	private String regStatus;
	private String active="no";
	private String role="ROLE_USER";
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String username, String email, long phoneno, String password, String confirmpassword,
			String regStatus, String active, String role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.regStatus = regStatus;
		this.active = active;
		this.role = role;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getPhoneno() {
		return phoneno;
	}



	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmpassword() {
		return confirmpassword;
	}



	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}



	public String getRegStatus() {
		return regStatus;
	}



	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}



	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", phoneno=" + phoneno + ", password="
				+ password + ", confirmpassword=" + confirmpassword + ", regStatus=" + regStatus + ", active=" + active
				+ ", role=" + role + "]";
	}
	
	
	

}
