package com.ecommerceOn.ecommerceOn.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleOrderID implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "order_id")
    private int idOrder;

    @Column(name = "article_id")
    private int idArticle;

}
