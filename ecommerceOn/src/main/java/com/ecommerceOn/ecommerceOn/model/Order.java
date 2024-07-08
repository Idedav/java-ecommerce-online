package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ecommerceOn.ecommerceOn.enums.State;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int idOrder;
	
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
			name = "article_order",
			joinColumns = @JoinColumn(name="order_id"),
			inverseJoinColumns = @JoinColumn(name="article_id")
	)
	private Set<Article> articles = new HashSet<>();

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name= "type_payment")
	@Enumerated(EnumType.STRING)
	private TypePayment typePayment;
	
	@Column(name= "state")
	@Enumerated(EnumType.STRING)
	private State state;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "order_time")
	private LocalTime orderTime;
	
}
