package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ArticleCartID implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
    @Column(name = "id_cart")
    private int idCart;

    @Column(name = "id_article")
    private int idArticle;
	
	
}
