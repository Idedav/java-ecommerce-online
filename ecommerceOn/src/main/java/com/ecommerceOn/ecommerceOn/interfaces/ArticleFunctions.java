package com.ecommerceOn.ecommerceOn.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerceOn.ecommerceOn.model.Article;

public interface ArticleFunctions {

	Optional<Article> getArticle(int idArticle);
	
	List<Article> getAllArticles();
	
	boolean checkQtyAvailable(int idArticle, int qtyOrdered);
	
	boolean updateQtyAvailable(int idArticle, int qtyOrdered);
	
}
