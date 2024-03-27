package com.example.cms.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.cms.exception.UserAlreadyExistByEmailException;
import com.example.cms.exception.UserNotFoundException;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class ApplicationExceptionHandler {
    
    private ErrorStructure<String> structure;

    private ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus status, String message, String rootCause) {
        return new ResponseEntity<ErrorStructure<String>> (structure
        		.setStatuscode(status.value())
        		.setMessage(message)
        		.setRootCause(rootCause), status);
    }
    
    @ExceptionHandler
    ResponseEntity<ErrorStructure<String>>handleUserAlreadyExistByEmail(UserAlreadyExistByEmailException ex){
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "User Already Exists with the given email ID");
    	
    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> userNotFoundExceptionHandle(UserNotFoundException ex ){
    	return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "user not found");
    }
   
    

   
}
