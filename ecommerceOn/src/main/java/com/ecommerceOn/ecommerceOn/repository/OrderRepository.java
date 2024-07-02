package com.ecommerceOn.ecommerceOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceOn.ecommerceOn.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
