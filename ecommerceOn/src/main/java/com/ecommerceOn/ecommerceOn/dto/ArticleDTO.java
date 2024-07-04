package com.ecommerceOn.ecommerceOn.dto;

import java.util.Objects;

public class ArticleDTO {

    private String id;
    private String name;
    private String description;
    private double unitPrice;
    private int qtyAvailable;
    
	public ArticleDTO(String id, String name, String description, double unitPrice, int qtyAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.qtyAvailable = qtyAvailable;
	}
	public ArticleDTO() {
		super();
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
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
    
    
  
	
}
