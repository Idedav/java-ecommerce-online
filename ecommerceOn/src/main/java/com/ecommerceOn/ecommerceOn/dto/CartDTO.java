package com.ecommerceOn.ecommerceOn.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.ecommerceOn.ecommerceOn.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	
    private int cartId;
    private UserDTO user;
    private Set<ArticleCartDTO> articles;
    
    private double totalPrice;
    

}
