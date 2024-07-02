package com.ecommerceOn.ecommerceOn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.enums.StatusLogging;
import com.ecommerceOn.ecommerceOn.interfaces.UserFunctions;
import com.ecommerceOn.ecommerceOn.model.User;
import com.ecommerceOn.ecommerceOn.repository.UserRepository;

@Service
public class ServiceUser implements UserFunctions{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public StatusLogging login(String email, String password) {
		
		Optional<User> userOpt = getUserByEmail(email);
		
		if(userOpt.isEmpty()) {
			
			return StatusLogging.WRONG_MAIL;
			
		}
		
		
		if(!userOpt.get().getPassword().equals(password)) {
			
			return StatusLogging.WRONG_PASSWORD;
			
		}
		
		return StatusLogging.LOGIN_SUCCESFULLY;
		
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
		
	}

}
