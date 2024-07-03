package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ArticleCartID implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
    @Column(name = "cart_id")
    private int idCart;

    @Column(name = "article_id")
    private String idArticle;

	public ArticleCartID(int idCart, String idArticle) {
		super();
		this.idCart = idCart;
		this.idArticle = idArticle;
	}

	public ArticleCartID() {
		super();
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public String getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idArticle, idCart);
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
		return Objects.equals(idArticle, other.idArticle) && idCart == other.idCart;
	}

	
	
}
