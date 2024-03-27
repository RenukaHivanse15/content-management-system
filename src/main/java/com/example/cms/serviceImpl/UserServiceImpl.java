package com.example.cms.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cms.DTO.UserRequest;
import com.example.cms.exception.UserAlreadyExistByEmailException;
import com.example.cms.model.User;
import com.example.cms.repository.UserRespository;
import com.example.cms.responseDTO.UserResponse;
import com.example.cms.service.UserService;
import com.example.cms.utility.ResponeStructure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UserRespository respository;
	private ResponeStructure<UserResponse> structure;
	
	private PasswordEncoder encoder;

	@Override
	public ResponseEntity<ResponeStructure<UserResponse>> registerUser(UserRequest userRequest) {
		if(respository.existsByEmail(userRequest.getEmail()))
			throw new UserAlreadyExistByEmailException("Failed to register user");

		User user=respository.save(mapToUserEntity(userRequest, new User()));
		
		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
				.setMessage("User Register")
				.setBody(mapToUserResponse(user)));
		
	}


	private UserResponse mapToUserResponse(User user) {
		return UserResponse.builder()
				.userId(user.getUserId())
				.username(user.getUsername())
				.email(user.getEmail())
				.build();
	
		/*
		 * UserResponse response=new UserResponse();
		 * response.setUserId(response.getUserId());
		 * response.setUsername(response.getUsername());
		 * response.setEmail(response.getEmail()); return response;
		 */
	}


	private User mapToUserEntity(UserRequest userRequest, User user) {
		user.setUsername(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword(encoder.encode(userRequest.getPassword()));
		return user;
	}

}
