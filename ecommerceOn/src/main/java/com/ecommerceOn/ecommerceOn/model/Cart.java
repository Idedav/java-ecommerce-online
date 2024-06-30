package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;


import com.ecommerceOn.ecommerceOn.enums.TypePayment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carts")
@Data
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cart")
	private int idUser;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_article")
    private Article flight;
    
	@Column(name = "qty_ordered")
	private int qtyOrdered;
	
	@Column(name= "payment_type")
	@Enumerated(EnumType.STRING)
	private TypePayment typePayment;
	

}
