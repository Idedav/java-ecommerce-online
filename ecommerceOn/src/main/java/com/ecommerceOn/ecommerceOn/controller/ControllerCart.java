package com.ecommerceOn.ecommerceOn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceOn.ecommerceOn.model.Cart;
import com.ecommerceOn.ecommerceOn.service.ServiceCart;


@RestController
@RequestMapping("ecommerceOn")
public class ControllerCart {

	
	@Autowired
	private ServiceCart serviceCart;
	
	@GetMapping(value="cart/{id_user}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getCartByUserId(@PathVariable("id_user") int idUser){
		
		 Optional<Cart> cartOpt = serviceCart.getCartByUserId(idUser);
		
		if(!cartOpt.isPresent()) {
			
			return new ResponseEntity<>(cartOpt.get(), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(cartOpt.get(), HttpStatus.OK);
		
		
	}
	
}
