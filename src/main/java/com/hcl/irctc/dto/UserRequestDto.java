package com.hcl.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

	private int userId;
	
	private String userName;
	
	private String password;

	private int otp;

	private String mailId;

	private Long mobileNo;

	
}
