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
	public Optional<Cart> getCartByUserId(int idUser) {
		
		return cartRepository.findByUserIdUser(idUser);
		
	}

	@Override
	public boolean existCart(int idUser) {
		
		return getCartByUserId(idUser).isPresent();
		
	}

	@Override
	public boolean deleteCart(int idUser) {
		
		if(!existCart(idUser)) {
			
			return false;
			
		}
		
		Cart cart = getCartByUserId(idUser).get();
		
		cartRepository.delete(cart);
		
		return true;
		
	}

	@Override
	public boolean updateCart(int idUser, String idArticle, int qtyOrdered) {
		// TODO Auto-generated method stub
		return false;
	}


}
