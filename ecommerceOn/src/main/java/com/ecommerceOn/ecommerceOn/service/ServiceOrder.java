package com.ecommerceOn.ecommerceOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.OrderFunctions;
import com.ecommerceOn.ecommerceOn.model.Order;
import com.ecommerceOn.ecommerceOn.repository.OrderRepository;

@Service
public class ServiceOrder implements OrderFunctions{
	
	@Autowired
	private OrderRepository orderReository;

	@Override
	public List<Order> getOrders(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> getOrder(int idOrder) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isConfirmedOrder(int idOrder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(int idOrder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmOrder(int idOrder) {
		// TODO Auto-generated method stub
		return false;
	}

}
