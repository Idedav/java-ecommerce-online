package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;

import com.ecommerceOn.ecommerceOn.enums.State;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int idOrder;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id", referencedColumnName = "id")
	private Cart cart;
	
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	@Column(name= "payment_type")
	@Enumerated(EnumType.STRING)
	private TypePayment typePayment;
	
	@Column(name= "state")
	@Enumerated(EnumType.STRING)
	private State state;
	
}
