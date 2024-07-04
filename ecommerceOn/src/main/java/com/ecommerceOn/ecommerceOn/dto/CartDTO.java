package com.ecommerceOn.ecommerceOn.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.ecommerceOn.ecommerceOn.model.User;

public class CartDTO {
	
    private int cartId;
    private UserDTO user;
    private Set<ArticleCartDTO> articles;
    
    private double totalPrice;

	public CartDTO(int cartId, UserDTO user, Set<ArticleCartDTO> articles, double totalPrice) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.articles = articles;
		this.totalPrice = totalPrice;
	}

	public CartDTO() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Set<ArticleCartDTO> getArticles() {
		return articles;
	}

	public void setArticles(Set<ArticleCartDTO> articles) {
		this.articles = articles;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    
    

}
