package com.ecommerceOn.ecommerceOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceOn.ecommerceOn.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
