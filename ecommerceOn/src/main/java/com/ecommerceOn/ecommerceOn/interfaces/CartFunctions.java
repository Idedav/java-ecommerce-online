package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.model.Cart;

public interface CartFunctions {
	
	Optional<Cart> getCart(int idCart, String idArticle);
	
	List<Cart> getCarts(int idCart);
	
	boolean existCart(int idCart, String idArticle);
	
	boolean deleteCart(int idCart, String idArticle);
	
	boolean updateCart(int idCart, String idArticle, int qtyOrdered);
	
	StatusOrder addCart(int idUser, String idArticle, int qtyOrdered, TypePayment typePayment);

}
