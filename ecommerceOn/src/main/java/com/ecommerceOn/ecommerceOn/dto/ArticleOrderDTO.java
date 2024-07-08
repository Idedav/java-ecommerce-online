package com.ecommerceOn.ecommerceOn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleOrderDTO {

    private ArticleDTO article;

    private int qtyOrdered;

}
