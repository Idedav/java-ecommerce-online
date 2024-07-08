package com.ecommerceOn.ecommerceOn.controller;

import com.ecommerceOn.ecommerceOn.dto.*;
import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerceOn.ecommerceOn.service.ServiceArticle;
import com.ecommerceOn.ecommerceOn.service.ServiceOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ecommerceOn")
public class ControllerOrder {
	
	@Autowired
	private ServiceOrder serviceOrder;

	@Autowired
	private ServiceArticle serviceArticle;

	@Autowired
	private ModelMapper modelMapper;

	//Map orderDTO
	public OrderDTO convertToOrderDTO(Order order)  {
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

		// Ottenere la lista di ArticleOrder per l order specificato
		List<ArticleOrder> articleOrders = serviceOrder.getArticleOrdersByOrderId(order.getIdOrder());

		// Mappatura delle ArticleOrderDTO
		Set<ArticleOrderDTO> articleOrderDTOS = articleOrders.stream()
				.map(articleOrder -> {
					ArticleOrderDTO articleOrderDTO = new ArticleOrderDTO();
					articleOrderDTO.setQtyOrdered(articleOrder.getQtyOrdered());

					Article article = serviceArticle.getArticle(articleOrder.getId().getIdArticle()).get();
					articleOrderDTO.setArticle(modelMapper.map(article, ArticleDTO.class));
					return articleOrderDTO;
				})
				.collect(Collectors.toSet());

		orderDTO.setArticles(articleOrderDTOS);

		return orderDTO;
	}

	@GetMapping(value="orders/{id_user}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getOrdersByIdUser(@PathVariable("id_user") int idUser){

		List<Order> orders = serviceOrder.getOrders(idUser);

		List<OrderDTO> orderDTOS = new ArrayList<>();

		for (Order order : orders){

			OrderDTO orderDTO = convertToOrderDTO(order);

			orderDTOS.add(orderDTO);
		};

		return new ResponseEntity<>(orderDTOS, HttpStatus.OK);


	}

	@GetMapping(value="order/{id_order}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getOrder(@PathVariable("id_order") int idOrder){

		Optional<Order> orderOpt = serviceOrder.getOrder(idOrder);

		if(!orderOpt.isPresent()) {

			return new ResponseEntity<>(orderOpt.get(), HttpStatus.BAD_REQUEST);

		}
		Order order = orderOpt.get();

		OrderDTO orderDTO = convertToOrderDTO(order);

		return new ResponseEntity<>(orderDTO, HttpStatus.OK);


	}

	@PostMapping(value="add-order/{id_cart}/{type_payment}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> addOrder(@PathVariable("id_cart") int idCart, @PathVariable("type_payment")TypePayment typePayment){

		Optional<Order> orderOpt = serviceOrder.addOrder(idCart, typePayment);

		if(orderOpt.isPresent()) {

			return new ResponseEntity<>(orderOpt.get(), HttpStatus.CREATED);

		}

		Order order = orderOpt.get();

		OrderDTO orderDTO = convertToOrderDTO(order);

		return new ResponseEntity<>(orderDTO, HttpStatus.BAD_REQUEST);


	}

	@PatchMapping(value="confirm-order/{id_order}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> confirmOrder(@PathVariable("id_order") int idOrder){

		boolean state = serviceOrder.confirmOrder(idOrder);

		if(state) {

			return new ResponseEntity<>(state, HttpStatus.OK);

		}

		return new ResponseEntity<>(state, HttpStatus.BAD_REQUEST);


	}

	@PatchMapping(value="cancel-order/{id_order}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> cancelOrder(@PathVariable("id_order") int idOrder){

		boolean state = serviceOrder.cancelOrder(idOrder);

		if(state) {

			return new ResponseEntity<>(state, HttpStatus.OK);

		}

		return new ResponseEntity<>(state, HttpStatus.BAD_REQUEST);


	}

}
