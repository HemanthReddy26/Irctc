package com.hcl.irctc.service.impl;

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

import com.hcl.irctc.dto.UserRequestDto;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.User;
import com.hcl.irctc.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl serviceImpl;
	
	static UserRequestDto userRequestDto;
	static User user;
	
	@BeforeAll
	public static void setUp(){
	userRequestDto=new UserRequestDto();
	userRequestDto.setUserName("Komal");
	userRequestDto.setPassword("ankita");
	userRequestDto.setMailId("komal@gmail.com");
	userRequestDto.setMobileNo(790377828L);
	user=new User();
	user.setUserId(101);
	user.setUserName("Komal");
	user.setMobileNo(7903778028L);
	}
	
	@Test
	@DisplayName("authentication : positive scenario")
	public void authenticationTest() throws IrctcException {
	//context
	when(userRepository.findUserByUserNameAndPassword("Komal", "ankita")).thenReturn(user);
	//event
	ResponseEntity<String> result = serviceImpl.authenticate("Komal","ankita");
	//outcome
	assertEquals("Login success", result.getBody());
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("authentication : negative scenario")
	public void authenticationTest1() {
	//context
	when(userRepository.findUserByUserNameAndPassword("pragati", "password")).thenReturn(null);
	//event and outcome
	assertThrows(IrctcException.class, ()->serviceImpl.authenticate("pragati", "password"));
	}

}
