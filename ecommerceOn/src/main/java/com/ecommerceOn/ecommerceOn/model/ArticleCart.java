package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCart implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ArticleCartID id;

    @Column (name = "qty_ordered")
    private int qtyOrdered ;

}