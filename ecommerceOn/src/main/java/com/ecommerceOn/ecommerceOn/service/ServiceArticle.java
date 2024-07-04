package com.ecommerceOn.ecommerceOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.ArticleFunctions;
import com.ecommerceOn.ecommerceOn.model.Article;
import com.ecommerceOn.ecommerceOn.model.Cart;
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

	@Override
	public boolean checkQtyAvailable(String idArticle, int qtyOrdered) {
		
		Article article = getArticle(idArticle).get();
		
		return article.getQtyAvailable() - qtyOrdered <= -1 ? false : true;
		
	}

	@Override
	public boolean updateQtyAvailable(String idArticle, int qtyOrdered) {
		
		Article article = getArticle(idArticle).get();
		
		article.setQtyAvailable(article.getQtyAvailable() - qtyOrdered);
		
		articleRepository.save(article);
		
		return true;
		
	}


}
