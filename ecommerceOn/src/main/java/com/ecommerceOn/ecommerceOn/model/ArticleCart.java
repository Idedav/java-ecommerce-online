package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "article_cart")
@Data
public class ArticleCart implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private ArticleCartID id;
	
    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name = "qty_ordered")
    private int qtyOrdered;

}