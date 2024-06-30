package com.ecommerceOn.ecommerceOn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.CartFunctions;
import com.ecommerceOn.ecommerceOn.repository.CartRepository;

@Service
public class ServiceCart implements CartFunctions{

	@Autowired
	private CartRepository cartRepository;
	
}
