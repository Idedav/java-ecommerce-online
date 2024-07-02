package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.Optional;

import com.ecommerceOn.ecommerceOn.enums.StatusLogging;
import com.ecommerceOn.ecommerceOn.model.User;


public interface UserFunctions {

	StatusLogging login(String email, String password);
	
	Optional<User> getUserByEmail(String email);
	
}
