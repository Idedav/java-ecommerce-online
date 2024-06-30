package com.ecommerceOn.ecommerceOn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.UserFunctions;
import com.ecommerceOn.ecommerceOn.repository.UserRepository;

@Service
public class ServiceUser implements UserFunctions{
	
	@Autowired
	private UserRepository userRepository;

}
