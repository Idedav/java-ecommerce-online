package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCartID implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
    @Column(name = "cart_id")
    private int idCart;

    @Column(name = "article_id")
    private int idArticle;
	
}
