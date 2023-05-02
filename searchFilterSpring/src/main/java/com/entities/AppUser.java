package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppUser {
	
	@Id
	@Column(length=20)
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public AppUser(String user,String pass){
		this.username=user;
		this.password=pass;
	}
	
	AppUser(){
		
	}
	
	
	
	
	
}
