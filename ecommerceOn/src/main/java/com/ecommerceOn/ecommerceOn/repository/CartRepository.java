package com.ecommerceOn.ecommerceOn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceOn.ecommerceOn.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	Optional<Cart> findByUserIdUser(int idUser);
	
}
