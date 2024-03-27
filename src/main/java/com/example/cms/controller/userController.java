package com.example.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.DTO.UserRequest;

import com.example.cms.responseDTO.UserResponse;
import com.example.cms.service.UserService;
import com.example.cms.utility.ResponeStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class userController {
	private UserService userService;
	
	@GetMapping("/test")
	public String test(){
		return "Hello from cms";	
	}
	
	@PostMapping("/users/register")
	public ResponseEntity<ResponeStructure<UserResponse>> registerUser(@RequestBody  UserRequest userRequest){
		return userService.registerUser(userRequest);
	}

}
