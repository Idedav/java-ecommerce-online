package com.ecommerceOn.ecommerceOn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceOn.ecommerceOn.service.ServiceArticle;


@RestController
@RequestMapping("ecommerceOn")
public class ControllerArticle {

	@Autowired
	private ServiceArticle serviceArticle;
	
}
