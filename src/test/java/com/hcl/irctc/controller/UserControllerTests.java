package com.hcl.irctc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.irctc.dto.Credentials;
import com.hcl.irctc.dto.UserRequestDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.service.impl.UserServiceImpl;

@SpringBootTest
public class UserControllerTests {

	@Mock
	UserServiceImpl userService;
	
	@InjectMocks
	UserController userController;
	
	static UserRequestDto userRequestDto;
	static Credentials credentials;
	static Credentials credentialsNegative;
	
	@BeforeAll
	public static void setUp() {
	userRequestDto = new UserRequestDto();
	userRequestDto.setUserName("Pragati");
	userRequestDto.setPassword("password");
	userRequestDto.setMobileNo(7903778028L);
	userRequestDto.setMailId("anu@gmail.com");
	
	credentials = new Credentials();
	credentials.setUserName("Pragati");
	credentials.setPassword("password");
	credentialsNegative = new Credentials();
	credentialsNegative.setUserName("Srishty");
	credentialsNegative.setPassword("sris");
	}
	
	@Test
	@DisplayName("Login Function: Positive Scenario")
	public void loginTest() throws IrctcException {
	//context
	when(userService.authenticate("Pragati", "password")).thenReturn(
	new ResponseEntity<>("Login success", HttpStatus.OK));
	//event
	ResponseEntity<String> result = userController.login(credentials);
	//outcome
	assertEquals("Login success", result.getBody());
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	
	@Test
	@DisplayName("Login Function: Negative Scenario")
	public void loginTest2() throws IrctcException {
	//context
	when(userService.authenticate("Srishty", "sris")).thenThrow(IrctcException.class);
	//event
	//outcome
	assertThrows(IrctcException.class, ()->userController.login(credentialsNegative));
	}


}
