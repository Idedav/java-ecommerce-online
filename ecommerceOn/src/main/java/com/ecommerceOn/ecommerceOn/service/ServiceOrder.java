package com.ecommerceOn.ecommerceOn.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ecommerceOn.ecommerceOn.enums.State;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.model.*;
import com.ecommerceOn.ecommerceOn.repository.ArticleOrderRepository;
import com.ecommerceOn.ecommerceOn.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.interfaces.OrderFunctions;
import com.ecommerceOn.ecommerceOn.repository.OrderRepository;

@Service
public class ServiceOrder implements OrderFunctions{
	
	@Autowired
	private OrderRepository orderReository;

	@Autowired
	private ArticleOrderRepository articleOrderRepository;

	@Autowired
	private ServiceCart serviceCart;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Order> getOrders(int idUser) {

		return orderReository.findByUserIdUser(idUser);

	}

	@Override
	public Optional<Order> getOrder(int idOrder) {

		return orderReository.findById(idOrder);

	}

	@Override
	public boolean isConfirmedOrder(int idOrder) {

		Order order = getOrder(idOrder).get();

		return order.getState() == State.CONFIRMED ? true : false;

	}

	@Override
	public boolean confirmOrder(int idOrder) {

		Order order = getOrder(idOrder).get();

		if (order.getState() != State.CREATED){

			return false;

		}
		order.setState(State.CONFIRMED);

		orderReository.save(order);

		return true;

	}

	@Override
	public boolean cancelOrder(int idOrder) {

		Order order = getOrder(idOrder).get();

		if (order.getState() != State.CREATED){

			return false;

		}
		order.setState(State.CANCELLED);

		orderReository.save(order);

		return true;

	}

	@Override
	public Optional<Order> addOrder(int idCart,TypePayment typePayment) {

		Optional<Cart> cartOpt = cartRepository.findById(idCart);
		/*CONTROLLO SE ESISTE IL CART*/
		if(!serviceCart.existCart(idCart)){
			return Optional.empty();
		}
		/*SE ESISTE CREO L ORDINE PRENDENDO IL CART*/
		Cart cart = cartOpt.get();

		Order newOrder = new Order();

		newOrder.setUser(cart.getUser());
		newOrder.setTotalPrice(cart.getTotalPrice());
		newOrder.setTypePayment(typePayment);
		newOrder.setState(State.CREATED);
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setOrderTime(LocalTime.now());

		orderReository.save(newOrder);

		/*CREO TUTTE LE RELAZIONI*/
		List<ArticleCart> articleCarts = serviceCart.getCartArticlesByCartId(idCart);


		for (ArticleCart articleCart : articleCarts){

			ArticleOrder articleOrder = new ArticleOrder();
			ArticleOrderID articleOrderID = new ArticleOrderID();

			articleOrderID.setIdArticle(articleCart.getId().getIdArticle());
			articleOrderID.setIdOrder(newOrder.getIdOrder());

			articleOrder.setId(articleOrderID);
			articleOrder.setQtyOrdered(articleCart.getQtyOrdered());

			articleOrderRepository.save(articleOrder);

		}
       /*ELIMINO IL CART*/
		serviceCart.deleteCart(cart.getUser().getIdUser());

		Optional<Order> orderOpt = Optional.ofNullable(newOrder);

		return orderOpt;

	}


	@Override
	public List<ArticleOrder> getArticleOrdersByOrderId(int idOrder) {

		return articleOrderRepository.findByIdIdOrder(idOrder);

	}

}
