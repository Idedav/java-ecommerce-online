package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "articles")
@Data
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private String idArticle;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;
	
	@Column(name= "unit_price")
	private BigDecimal unitPrice;
	
	@Column(name= "qty_available")
	private int qtyAvailable;
	
    @OneToMany(mappedBy = "article")
    private Set<ArticleCart> articleCarts;
    
    
}
