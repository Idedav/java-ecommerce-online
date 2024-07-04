package com.ecommerceOn.ecommerceOn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceOn.ecommerceOn.model.ArticleCart;
import com.ecommerceOn.ecommerceOn.model.ArticleCartID;

public interface ArticleCartRepository extends JpaRepository<ArticleCart, ArticleCartID>{

    List<ArticleCart> findByIdIdCart(int idCart);
	
}
