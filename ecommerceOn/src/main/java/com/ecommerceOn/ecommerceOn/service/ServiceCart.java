package com.ecommerceOn.ecommerceOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.interfaces.CartFunctions;
import com.ecommerceOn.ecommerceOn.model.Article;
import com.ecommerceOn.ecommerceOn.model.ArticleCart;
import com.ecommerceOn.ecommerceOn.model.ArticleCartID;
import com.ecommerceOn.ecommerceOn.model.Cart;
import com.ecommerceOn.ecommerceOn.model.User;
import com.ecommerceOn.ecommerceOn.repository.ArticleCartRepository;
import com.ecommerceOn.ecommerceOn.repository.ArticleRepository;
import com.ecommerceOn.ecommerceOn.repository.CartRepository;
import com.ecommerceOn.ecommerceOn.repository.UserRepository;

@Service
public class ServiceCart implements CartFunctions{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ArticleCartRepository articleCartRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<Cart> getCartByUserId(int idUser) {
		
		return cartRepository.findByUserIdUser(idUser);
		
	}

	@Override
	public boolean existCart(int idUser) {
		
		return getCartByUserId(idUser).isPresent();
		
	}

	@Override
	public boolean deleteCart(int idUser) {
		
		if(!existCart(idUser)) {
			
			return false;
			
		}
		
		Cart cart = getCartByUserId(idUser).get();
		
		cartRepository.delete(cart);
		
		return true;
		
	}

	@Override
	public boolean updateCart(int idUser, String idArticle, int qtyOrdered) {
		// TODO Auto-generated method stub
		return false;
	}

//	DA REFACTORZZARE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@Override
	public StatusOrder addCart(int idUser, String idArticle, int qtyOrdered) {
		
		Optional<Cart> cartOpt = getCartByUserId(idUser);
		Cart cart = cartOpt.orElse(null);
		Article article = articleRepository.findById(idArticle).get();
		
//		CONTROLLO LA QUANTITA DISPONIBILE DELL ARTICOLO
		if(article.getQtyAvailable() - qtyOrdered <= -1) {
			
			return StatusOrder.QTY_NOT_AVAILABLE;
			
		}
		
		
		
//		CONTROLLO SE ESISTE IL CARRELLO
		if(!cartOpt.isPresent()) {
			
//			SE NON ESISTE UN CART PER QUELLO USER ALLORA LO CREO
			Cart newCart = new Cart();
			
			User user = userRepository.findById(idUser).get();
			
			newCart.setUser(user);
			newCart.setTotalPrice(article.getUnitPrice() * qtyOrdered);
			
			cartRepository.save(newCart);
			
//			CREO LA RELAZIONE NELLA TABELLA ARTICLECART
			ArticleCartID articleCartiID = new ArticleCartID(newCart.getIdCart(), idArticle);
			ArticleCart articleCart = new ArticleCart();
			
			articleCart.setId(articleCartiID);
			articleCart.setQtyOrdered(qtyOrdered);
			
			articleCartRepository.save(articleCart);
			
//			AGGIORNO LA QUANTITA DISPONIBILE DELL ARTICOLO
			
			article.setQtyAvailable(article.getQtyAvailable() - qtyOrdered);
			
			articleRepository.save(article);
			
			return StatusOrder.CREATED_SUCCESSFULY;
			
		}
//		SE ESISTE LO AGGIORNO
		
		
		
//		CONTROLLO SE ESISTE GIA UN ARTICOLO DENTRO QUEL CARRELLO
		ArticleCartID articleCartiID = new ArticleCartID(cart.getIdCart(), idArticle);
		Optional<ArticleCart> articleCartOpt = articleCartRepository.findById(articleCartiID);
		if(articleCartOpt.isPresent()) {
//			SE ESISTE AGGIORNO LA QUANTITA ORDINATA DI QUELL ARTICOLO
			ArticleCart articleCart = articleCartOpt.get();
			
			articleCart.setQtyOrdered(articleCart.getQtyOrdered() + qtyOrdered);
			
			articleCartRepository.save(articleCart);
			
//			AGGIORNO IL PREZZO TOTALE DEL CART
			
			cart.setTotalPrice(cart.getTotalPrice() + article.getUnitPrice() * qtyOrdered);
			
			cartRepository.save(cart);
			
//			AGGIORNO LA QUANTITA DISPONIBILE DELL ARTICOLO
			article.setQtyAvailable(article.getQtyAvailable() - qtyOrdered);
			
			articleRepository.save(article);
			
			return StatusOrder.UPDATED_SUCCESSFULY;
			
		}
//		SE NON ESISTE L ARTICOLO CREO UNA NUOVA RELAZIONE
		ArticleCart articleCart = new ArticleCart();
		
		articleCart.setId(articleCartiID);
		articleCart.setQtyOrdered(qtyOrdered);
		
		articleCartRepository.save(articleCart);
		
//		AGGIORNO IL PREZZO TOTALE DEL CART
		
		cart.setTotalPrice(cart.getTotalPrice() + article.getUnitPrice() * qtyOrdered);
		
		cartRepository.save(cart);
		
//		AGGIORNO LA QUANTITA DISPONIBILE DELL ARTICOLO
		
		article.setQtyAvailable(article.getQtyAvailable() - qtyOrdered);
		
		articleRepository.save(article);
		
		return StatusOrder.ADDED_SUCCESSFULY;
		
		
	}


}
