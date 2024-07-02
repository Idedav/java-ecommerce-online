package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ArticleCartID implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private int cartId;
		
	private String articleId;

	public ArticleCartID(int cartId, String articleId) {
		super();
		this.cartId = cartId;
		this.articleId = articleId;
	}

	public ArticleCartID() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleId, cartId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleCartID other = (ArticleCartID) obj;
		return Objects.equals(articleId, other.articleId) && cartId == other.cartId;
	}

	
	
}
