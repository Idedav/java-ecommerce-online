package com.ecommerceOn.ecommerceOn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCart {

	private int idUser;
	
	private int idArticle;
	
	private int qtyOrdered;
	
}
