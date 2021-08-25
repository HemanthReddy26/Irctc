package com.hcl.irctc.exception;

public class IrctcException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public IrctcException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
