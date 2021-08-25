package com.hcl.irctc.exception;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.irctc.ApiStatusCode;
import com.hcl.irctc.util.DateTimeUtil;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IrctcException.class)
	public ResponseEntity<ErrorResponse> IrctcExceptionHandler(IrctcException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(400);
		errorResponse.setLocalDateTime(DateTimeUtil.dateTime());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(MethodArgumentNotValidException ex) {
		
		ValidationErrorResponse errorResponse = new ValidationErrorResponse();
		errorResponse.setMessage("Input Data is Invalid");
		errorResponse.setLocalDateTime(DateTimeUtil.dateTime());
		errorResponse.setStatusCode(ApiStatusCode.INVALID_DATA);
		
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		System.out.println(errors);
		errors.forEach(error -> {
			errorResponse.getErrorsMap().put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ConstraintViolationException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(401);
		errorResponse.setLocalDateTime(DateTimeUtil.dateTime());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
	}
	
}
