package com.example.cms.serviceImpl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cms.DTO.UserRequest;
import com.example.cms.exception.UserAlreadyExistByEmailException;
import com.example.cms.exception.UserNotFoundException;
import com.example.cms.model.User;
import com.example.cms.repository.UserRespository;
import com.example.cms.responseDTO.UserResponse;
import com.example.cms.service.UserService;
import com.example.cms.utility.ResponeStructure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UserRespository repository;
	private ResponeStructure<UserResponse> structure;

	private PasswordEncoder encoder;

	@Override
	public ResponseEntity<ResponeStructure<UserResponse>> registerUser(UserRequest userRequest) {
		if(repository.existsByEmail(userRequest.getEmail()))
			throw new UserAlreadyExistByEmailException("Failed to register user");

		User user=repository.save(mapToUserEntity(userRequest, new User()));

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
        
        
    @Override
	public ResponseEntity<ResponeStructure<UserResponse>> softDelete(String email) {
    	return repository.findByEmail(email).map(user->{
    		user.setDeleted(true);
    		repository.save(user);
    		
    		UserResponse response = mapToUserResponse(user);
    		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
    				.setMessage("user is softdeleted")
    				.setBody(response));
    		}).orElseThrow(()-> new UserNotFoundException("user with ID "+email+" not found exception"));
//    	Optional<User> byEmail = respository.findByEmail(email);
//    	if(byEmail.isPresent())
//    	{
//    		User user = byEmail.get();
//    		user.setDeleted(true);
//    		UserResponse response = mapToUserResponse(user);
//    		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
//    				.setMessage("user soft deleted succesfuuly").setBody(response));
//    	}
//    	else {
//    	return null;
    }
	@Override
	public ResponseEntity<ResponeStructure<UserResponse>> findByEmail(String email) {
		return repository.findByEmail(email).map(user->{
			UserResponse response = mapToUserResponse(user);
			return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
					.setMessage("user with "+email+" is found")
					.setBody(response));
		}).orElseThrow(()-> new UserNotFoundException("user not found"));
	}
}
