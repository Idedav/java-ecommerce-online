package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerceOn.ecommerceOn.dto.CartDTO;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.model.ArticleOrder;
import com.ecommerceOn.ecommerceOn.model.Order;
import org.aspectj.weaver.ast.Or;

public interface OrderFunctions {

	List<Order> getOrders(int idUser);
	
	Optional<Order> getOrder(int idOrder);
	
	boolean isConfirmedOrder(int idOrder);
	
	boolean confirmOrder(int idOrder);

	Optional<Order> addOrder(int idCart, TypePayment typePayment);

	List<ArticleOrder> getArticleOrdersByOrderId(int idOrder);
}
