package com.ecommerceOn.ecommerceOn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.OrderFunctions;
import com.ecommerceOn.ecommerceOn.repository.OrderRepository;

@Service
public class ServiceOrder implements OrderFunctions{
	
	@Autowired
	private OrderRepository orderReository;

}
