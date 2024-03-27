package com.example.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cms.model.User;

public interface UserRespository extends JpaRepository<User, Integer>{
	//	findBy use for fetch operation
	public Optional<User> findByEmail(String email);

	public boolean existsByEmail(String email);

}