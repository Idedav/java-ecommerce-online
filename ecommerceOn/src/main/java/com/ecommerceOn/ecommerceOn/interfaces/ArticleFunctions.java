package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerceOn.ecommerceOn.model.Article;

public interface ArticleFunctions {

	Optional<Article> getArticle(String idArticle);
	
	List<Article> getAllArticles();
	
	boolean checkQtyAvailable(String idArticle, int qtyOrdered);
	
	boolean updateQtyAvailable(String idArticle, int qtyOrdered);
	
}
