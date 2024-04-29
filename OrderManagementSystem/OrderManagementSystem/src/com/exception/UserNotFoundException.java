package com.exception;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4864534575543660225L;
	private String message;

	public UserNotFoundException(String message) {
		
		this.message = message;
	}
    public String getMessage() {
    	return message;
    }
}
