package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "articles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int idArticle;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;

	@Column(name = "thumb")
	private String thumb;
	
	@Column(name= "unit_price")
	private double unitPrice;
	
	@Column(name= "qty_available")
	private int qtyAvailable;

    
}
