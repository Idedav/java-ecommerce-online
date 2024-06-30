package com.ecommerceOn.ecommerceOn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.ArticleFunctions;
import com.ecommerceOn.ecommerceOn.repository.ArticleRepository;

@Service
public class ServiceArticle implements ArticleFunctions{
	
	@Autowired
	private ArticleRepository articleRepository;

}
