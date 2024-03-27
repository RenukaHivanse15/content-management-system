package com.example.cms.service;

import org.springframework.http.ResponseEntity;

import com.example.cms.DTO.UserRequest;

import com.example.cms.responseDTO.UserResponse;
import com.example.cms.utility.ResponeStructure;

public interface UserService {

public ResponseEntity<ResponeStructure<UserResponse>> registerUser(UserRequest userRequest);

}