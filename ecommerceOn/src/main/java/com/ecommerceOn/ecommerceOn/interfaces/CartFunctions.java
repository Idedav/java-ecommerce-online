package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.Optional;

import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.model.Cart;

public interface CartFunctions {
	
	Optional<Cart> getCartByUserId(int idUser);
	
	boolean existCart(int idUser);
	
	boolean deleteCart(int idUser);
	
	boolean updateCart(int idUser, String idArticle, int qtyOrdered);
	
	StatusOrder addCart(int idUser, String idArticle, int qtyOrdered);

}
