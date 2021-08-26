package com.hcl.irctc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.irctc.exception.IrctcException;
import com.hcl.irctc.model.User;
import com.hcl.irctc.repository.UserRepository;
import com.hcl.irctc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	 @Override
	public ResponseEntity<String> authenticate(String username, String password) throws IrctcException {
	User user = userRepository.findUserByUserNameAndPassword(username, password);
	if (user != null)
	return new ResponseEntity<>("Login success", HttpStatus.OK);
	throw new IrctcException("Invalid Credentials!");
	}
}
