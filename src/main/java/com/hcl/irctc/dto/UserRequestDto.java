package com.hcl.irctc.dto;

public class UserRequestDto {

	private int userId;
	
	private String userName;

	private int otp;

	private String mailId;

	private int mobileNo;

	public UserRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequestDto(int userId, String userName, int otp, String mailId, int mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.otp = otp;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
	}

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
	
	
}
