package com.cts.training.userservice;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserDTO {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String email;
	private long phoneno;
	private String password;
	private String confirmpassword;
	private String active="no";
	private String role="ROLE_USER";
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int id, String username, String email, long phoneno, String password, String confirmpassword,
			String active, String role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.confirmpassword = confirmpassword;
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
		return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", phoneno=" + phoneno
				+ ", password=" + password + ", confirmpassword=" + confirmpassword + ", active=" + active + ", role="
				+ role + "]";
	}
	
	
	}
