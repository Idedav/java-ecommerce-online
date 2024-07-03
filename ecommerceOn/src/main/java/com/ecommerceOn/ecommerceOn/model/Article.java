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
	private double unitPrice;
	
	@Column(name= "qty_available")
	private int qtyAvailable;

	public Article(String idArticle, String name, String description, double unitPrice, int qtyAvailable) {
		super();
		this.idArticle = idArticle;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.qtyAvailable = qtyAvailable;
	}

	public Article() {
		super();
	}

	public String getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQtyAvailable() {
		return qtyAvailable;
	}

	public void setQtyAvailable(int qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, idArticle, name, qtyAvailable, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(description, other.description) && Objects.equals(idArticle, other.idArticle)
				&& Objects.equals(name, other.name) && qtyAvailable == other.qtyAvailable
				&& Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return idArticle;
	}
    
    
}
