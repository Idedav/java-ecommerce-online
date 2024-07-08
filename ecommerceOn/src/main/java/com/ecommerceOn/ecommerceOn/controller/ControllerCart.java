package com.ecommerceOn.ecommerceOn.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceOn.ecommerceOn.dto.ArticleCartDTO;
import com.ecommerceOn.ecommerceOn.dto.ArticleDTO;
import com.ecommerceOn.ecommerceOn.dto.CartDTO;
import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.model.Article;
import com.ecommerceOn.ecommerceOn.model.ArticleCart;
import com.ecommerceOn.ecommerceOn.model.Cart;
import com.ecommerceOn.ecommerceOn.model.RequestCart;
import com.ecommerceOn.ecommerceOn.service.ServiceArticle;
import com.ecommerceOn.ecommerceOn.service.ServiceCart;


@RestController
@RequestMapping("ecommerceOn")
public class ControllerCart {

	
	@Autowired
	private ServiceCart serviceCart;
	
	@Autowired
	private ServiceArticle serviceArticle;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Map cartDTO
    public CartDTO convertToCartDTO(Cart cart)  {
        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);

        // Ottenere la lista di CartArticle per il carrello specificato
        List<ArticleCart> articleCarts = serviceCart.getCartArticlesByCartId(cart.getIdCart());

        // Mappatura delle CartArticleDTO
        Set<ArticleCartDTO> articleCartDTOs = articleCarts.stream()
                .map(articleCart -> {
                	ArticleCartDTO articleCartDTO = new ArticleCartDTO();
                	articleCartDTO.setQtyOrdered(articleCart.getQtyOrdered());

                    Article article = serviceArticle.getArticle(articleCart.getId().getIdArticle()).get();
                    articleCartDTO.setArticle(modelMapper.map(article, ArticleDTO.class));
                    return articleCartDTO;
                })
                .collect(Collectors.toSet());

        cartDTO.setArticles(articleCartDTOs);

        return cartDTO;
    }
	
	@GetMapping(value="cart/{id_user}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getCartByUserId(@PathVariable("id_user") int idUser){
		
		 Optional<Cart> cartOpt = serviceCart.getCartByUserId(idUser);
		
		if(!cartOpt.isPresent()) {
			
			return new ResponseEntity<>(cartOpt.get(), HttpStatus.BAD_REQUEST);
			
		}
		Cart cart = cartOpt.get();
	    
	    CartDTO cartDTO = convertToCartDTO(cart);
		
		return new ResponseEntity<>(cartDTO, HttpStatus.OK);
		
		
	}
	
	@PostMapping(value="add-cart", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> addCart(@RequestBody RequestCart requestCart ){
		
		 StatusOrder status = serviceCart.addCart(requestCart.getIdUser(), requestCart.getIdArticle(), requestCart.getQtyOrdered());
		
		if(status != StatusOrder.QTY_NOT_AVAILABLE) {
			
			return new ResponseEntity<>(status, HttpStatus.CREATED);
			
		}
		
		return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
		
		
	}
	
	@DeleteMapping(value="delete-cart/{id_user}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteCart(@PathVariable("id_user") int idUser){
		
		 StatusOrder status = serviceCart.deleteCart(idUser);
		
		if(status == StatusOrder.DELETE_SUCCESFULY) {
			
			return new ResponseEntity<>(status, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
		
		
	}
	
}
