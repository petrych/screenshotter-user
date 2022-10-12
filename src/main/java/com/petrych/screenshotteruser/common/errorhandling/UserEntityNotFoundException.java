package com.petrych.screenshotteruser.common.errorhandling;

public class UserEntityNotFoundException extends RuntimeException {
	
	private static final String MESSAGE_WITH_USERNAME_TEMPLATE = "Username '%s' does not exist";
	
	public UserEntityNotFoundException(String userName) {
		
		super(String.format(MESSAGE_WITH_USERNAME_TEMPLATE, userName));
	}
	
}
