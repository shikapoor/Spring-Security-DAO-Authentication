package com.in28Minutes.learning.restfulWebService.restfulwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.dto.CustomizedUserDetails;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.entity.UserEntity;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user = userRepository.getUserByUsername(username);
		 if (user == null) {
	            throw new UsernameNotFoundException("User not found.");
	        }
		
		
		 
		 return new CustomizedUserDetails(user);
	}

}
