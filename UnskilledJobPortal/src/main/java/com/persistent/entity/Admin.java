package com.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {

	
	@Id
	@Column(name="USERNAME" , columnDefinition = "VARCHAR2(30)")
	private String username;
	
	@Column(name="PASSWORD" , columnDefinition = "VARCHAR2(30)" , nullable = false)
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}

}
