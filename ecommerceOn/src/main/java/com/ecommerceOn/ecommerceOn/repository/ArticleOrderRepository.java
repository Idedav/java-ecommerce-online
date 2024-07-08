package com.ecommerceOn.ecommerceOn.repository;

import com.ecommerceOn.ecommerceOn.model.ArticleCart;
import com.ecommerceOn.ecommerceOn.model.ArticleOrder;
import com.ecommerceOn.ecommerceOn.model.ArticleOrderID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleOrderRepository extends JpaRepository<ArticleOrder, ArticleOrderID> {

    List<ArticleOrder> findByIdIdOrder(int idOrder);

}
