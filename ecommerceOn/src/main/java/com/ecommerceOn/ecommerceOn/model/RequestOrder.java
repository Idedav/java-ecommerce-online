package com.ecommerceOn.ecommerceOn.model;

import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrder {

    private int idCart;
    private TypePayment typePayment;

}
