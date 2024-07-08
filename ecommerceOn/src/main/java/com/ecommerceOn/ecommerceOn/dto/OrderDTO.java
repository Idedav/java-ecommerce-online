package com.ecommerceOn.ecommerceOn.dto;

import com.ecommerceOn.ecommerceOn.enums.State;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private int idOrder;

    private UserDTO user;

    private Set<ArticleOrderDTO> articles;

    private double totalPrice;

    private TypePayment typePayment;

    private State state;

    private LocalDate orderDate;

    private LocalTime orderTime;
}
