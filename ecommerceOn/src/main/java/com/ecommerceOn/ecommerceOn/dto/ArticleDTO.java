package com.ecommerceOn.ecommerceOn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private int id;
    private String name;
    private String description;
    private String thumb;
    private double unitPrice;
    private int qtyAvailable;
  
	
}
