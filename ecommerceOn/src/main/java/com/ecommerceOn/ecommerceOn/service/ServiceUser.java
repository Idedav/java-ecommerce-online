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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUser(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
