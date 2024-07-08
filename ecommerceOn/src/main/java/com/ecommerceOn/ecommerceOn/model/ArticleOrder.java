package com.ecommerceOn.ecommerceOn.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "article_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ArticleOrderID id;

    @Column(name = "qty_ordered")
    private int qtyOrdered ;

}
