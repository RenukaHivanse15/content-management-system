package com.example.cms.security;

import java.util.function.Supplier;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cms.repository.UserRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

	private UserRespository userRespository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return  userRespository.findByEmail(username).map(user->new CustomUserDetails(user))
				.orElseThrow(()-> new UsernameNotFoundException("User Not Exist"));
	}

	//	when ever a method return an interface we need to return subclass object
	//	we can access the user of database by using repository

}
