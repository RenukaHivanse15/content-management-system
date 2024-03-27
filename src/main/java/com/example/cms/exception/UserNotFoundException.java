package com.example.cms.exception;

import lombok.Getter;
@SuppressWarnings("serial")
@Getter
public class UserNotFoundException extends RuntimeException {
	
		private String message;
		public UserNotFoundException(String message) {
	      this.message = message;
		}
		
		public String getMessage() {
			return message;
		}

		

}
