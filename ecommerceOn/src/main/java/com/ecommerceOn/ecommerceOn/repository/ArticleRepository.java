package com.ecommerceOn.ecommerceOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceOn.ecommerceOn.model.Article;


public interface ArticleRepository extends JpaRepository<Article, String> {

}
