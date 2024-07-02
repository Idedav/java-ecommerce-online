package com.ecommerceOn.ecommerceOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.ArticleFunctions;
import com.ecommerceOn.ecommerceOn.model.Article;
import com.ecommerceOn.ecommerceOn.repository.ArticleRepository;

@Service
public class ServiceArticle implements ArticleFunctions{
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Optional<Article> getArticle(String idArticle) {
		
		return articleRepository.findById(idArticle);
		
	}

	@Override
	public List<Article> getAllArticles() {
		
		return articleRepository.findByQtyAvailableGreaterThan(0);
		
	}

}
