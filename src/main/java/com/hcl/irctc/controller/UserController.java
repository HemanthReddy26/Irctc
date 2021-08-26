package com.hcl.irctc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.irctc.dto.Credentials;
import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.service.impl.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/users/login")
	public ResponseEntity<String> login(@Valid @RequestBody Credentials credentials) throws IrctcException {
	return userServiceImpl.authenticate(credentials.getUserName(), credentials.getPassword());
	}

}
