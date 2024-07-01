package com.ecommerceOn.ecommerceOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.interfaces.CartFunctions;
import com.ecommerceOn.ecommerceOn.model.Cart;
import com.ecommerceOn.ecommerceOn.repository.CartRepository;

@Service
public class ServiceCart implements CartFunctions{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Optional<Cart> getCart(int idCart, String idArticle) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Cart> getCarts(int idCart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existCart(int idCart, String idArticle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCart(int idCart, String idArticle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCart(int idCart, String idArticle, int qtyOrdered) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StatusOrder addCart(int idUser, String idArticle, int qtyOrdered, TypePayment typePayment) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
