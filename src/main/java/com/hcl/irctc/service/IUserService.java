package com.hcl.irctc.service;

import org.springframework.http.ResponseEntity;

import com.hcl.irctc.exception.IrctcException;

public interface IUserService {
	
	public ResponseEntity<String> authenticate(String userName, String password) throws IrctcException;

}
