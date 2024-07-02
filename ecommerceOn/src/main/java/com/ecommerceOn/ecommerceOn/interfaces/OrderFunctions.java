package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerceOn.ecommerceOn.model.Order;

public interface OrderFunctions {

	List<Order> getOrders(int idUser);
	
	Optional<Order> getOrder(int idOrder);
	
	boolean isConfirmedOrder(int idOrder);
	
	boolean deleteOrder(int idOrder);
	
	boolean confirmOrder(int idOrder);
	
}
