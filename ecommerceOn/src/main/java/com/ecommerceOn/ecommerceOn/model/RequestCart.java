package com.ecommerceOn.ecommerceOn.model;

import java.util.Objects;

public class RequestCart {

	private int idUser;
	
	private String idArticle;
	
	private int qtyOrdered;

	public RequestCart(int idUser, String idArticle, int qtyOrdered) {
		super();
		this.idUser = idUser;
		this.idArticle = idArticle;
		this.qtyOrdered = qtyOrdered;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idArticle, idUser, qtyOrdered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestCart other = (RequestCart) obj;
		return Objects.equals(idArticle, other.idArticle) && idUser == other.idUser && qtyOrdered == other.qtyOrdered;
	}
	
	
	
}
