package com.hcl.irctc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="otp")
	private int otp;
	
	@Column(name="mail_id")
	private String mailId;
	
	@Column(name="mobile_no")
	private int mobileNo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public User(int userId, String userName, int otp, String mailId, int mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.otp = otp;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
	}

	public User() {
		super();
	}

	
}
