package com.ecommerceOn.ecommerceOn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceOn.ecommerceOn.enums.StatusLogging;
import com.ecommerceOn.ecommerceOn.model.RequestLogin;
import com.ecommerceOn.ecommerceOn.model.User;
import com.ecommerceOn.ecommerceOn.service.ServiceUser;


@RestController
@RequestMapping("ecommerceOn")
public class ControllerUser {
	
	@Autowired
	private ServiceUser serviceUser;
	
	
	@PostMapping(value="login", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> login(@RequestBody RequestLogin requestLogin){
		
		 StatusLogging status = serviceUser.login(requestLogin.getEmail(), requestLogin.getPassword());
		
		if(status != StatusLogging.LOGIN_SUCCESFULLY) {
			
			return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
			
		}
		
		User user = serviceUser.getUserByEmail(requestLogin.getEmail()).get();
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping(value="get-user/{email}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email){
		
		 Optional<User> userOpt = serviceUser.getUserByEmail(email);
		
		if(!userOpt.isPresent()) {
			
			return new ResponseEntity<>(userOpt.get(), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(userOpt.get(), HttpStatus.OK);
		
		
	}

}
