package com.ecommerceOn.ecommerceOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceOn.ecommerceOn.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer>{

    List<Order> findByUserIdUser(int idUser);

    List<Order> findAllByUserIdUserOrderByOrderDateDescOrderTimeDesc(int idUser);
}
