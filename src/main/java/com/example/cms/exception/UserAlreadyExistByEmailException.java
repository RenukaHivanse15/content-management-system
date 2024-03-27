package com.example.cms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter


public class UserAlreadyExistByEmailException extends RuntimeException {
	private String message;
	public UserAlreadyExistByEmailException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	
	

}
