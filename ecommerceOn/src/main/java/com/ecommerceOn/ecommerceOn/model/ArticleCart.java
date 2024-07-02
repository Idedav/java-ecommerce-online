package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "article_cart")
@Data
public class ArticleCart implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ArticleCartID id;

    @Column (name = "qty_ordered")
    private int qtyOrdered ;

	public ArticleCart(ArticleCartID id, int qtyOrdered) {
		super();
		this.id = id;
		this.qtyOrdered = qtyOrdered;
	}

	public ArticleCart() {
		super();
	}

	public ArticleCartID getId() {
		return id;
	}

	public void setId(ArticleCartID id) {
		this.id = id;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, qtyOrdered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleCart other = (ArticleCart) obj;
		return Objects.equals(id, other.id) && qtyOrdered == other.qtyOrdered;
	}
    
    

}