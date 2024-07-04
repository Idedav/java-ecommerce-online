package com.ecommerceOn.ecommerceOn.dto;

public class ArticleCartDTO {

	
	private ArticleDTO article;
	private int qtyOrdered;
	

	public ArticleCartDTO(ArticleDTO article, int qtyOrdered) {
		super();
		this.article = article;
		this.qtyOrdered = qtyOrdered;
	}

	public ArticleCartDTO() {
		super();
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }
	
	
	
}
