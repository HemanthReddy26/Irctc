package com.hcl.irctc.dto;

import javax.validation.constraints.Size;

public class Credentials {
	
	@Size(max=20,min=3,message="User name should be greater than 2 and less than 20")
	private String userName;
	
	@Size(max=20,min=4,message="Password should be greater than 3 and less than 20")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Credentials(String userName,String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
