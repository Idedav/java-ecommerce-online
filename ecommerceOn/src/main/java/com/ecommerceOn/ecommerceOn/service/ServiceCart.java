package com.ecommerceOn.ecommerceOn.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ecommerceOn.ecommerceOn.exception.CartNotFoundException;
import com.ecommerceOn.ecommerceOn.model.*;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceOn.ecommerceOn.enums.StatusOrder;
import com.ecommerceOn.ecommerceOn.enums.TypePayment;
import com.ecommerceOn.ecommerceOn.interfaces.CartFunctions;
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
	
	@Autowired
	private ServiceArticle serviceArticle;

	@Override
	public Optional<Cart> getCartByUserId(int idUser) {

		Optional<Cart> cartOpt = cartRepository.findByUserIdUser(idUser);

		return Optional.ofNullable(cartOpt.orElseThrow(() -> new CartNotFoundException("Cart not found for this user")));

	}

	@Override
	public boolean existCart(int idUser) {
		
		return getCartByUserId(idUser).isPresent();
		
	}

	@Transactional
	@Override
	public StatusOrder deleteCart(int idUser) {
		/*CONTROLLO SE ESISTE IL CART*/
		if(!existCart(idUser)) {
			
			return StatusOrder.DELETE_UNSUCCESFULY;
			
		}
		/*SE ESISTE LO PRENDO*/
		Cart cart = cartRepository.findByUserIdUser(idUser).get();
		/*PRENDO ANCHE LE RELAZIONI*/
		List<ArticleCart> articleCarts = articleCartRepository.findByIdIdCart(cart.getIdCart());
		/*AGGIORNO TRAMITE UN CICLO LA QUANTITA DISPONIBILE DEGLI ARTICOLI PRESENTI NELLA RELAZIONE ARTICLECART*/
		for (ArticleCart articleCart : articleCarts){

			Article article = serviceArticle.getArticle(articleCart.getId().getIdArticle()).get();

			article.setQtyAvailable(article.getQtyAvailable() + articleCart.getQtyOrdered());

			articleRepository.save(article);

		}
		/*ELIMINO IL CARRELLO*/
		cartRepository.delete(cart);


		return StatusOrder.DELETE_SUCCESFULY;
		
	}

	@Transactional
	@Override
	public StatusOrder deleteArticleToCart(int idUser, int idArticle) {

		Cart cart = cartRepository.findByUserIdUser(idUser).get();

		ArticleCartID articleCartID = new ArticleCartID(cart.getIdCart(), idArticle);


		Optional<ArticleCart> articleCartOpt = articleCartRepository.findById(articleCartID);
		/*CONTROLLO L ESISTENZA DI RELAZIONE ARTICLECART*/
		if(articleCartOpt.isEmpty()){

			return StatusOrder.DELETE_UNSUCCESFULY;

		}
		/*SE ESISTE LO PRENDO*/
		ArticleCart articleCart = articleCartOpt.get();
		/*AGGIORNO LA QUANTITA DISPONIBILE DEGLI ARTICOLI PRESENTI NELLA RELAZIONE ARTICLECART*/
		Article article = serviceArticle.getArticle(articleCart.getId().getIdArticle()).get();
		article.setQtyAvailable(article.getQtyAvailable() + articleCart.getQtyOrdered());
		articleRepository.save(article);
		/*ELIMINO L ARTICOLO DAL CARRELLO*/
		articleCartRepository.delete(articleCart);
		/*VERIFICO SE NEL CARRELLO ESISTONO ANCORA ARTICOLI SE NON ESISTO ELIMINO ANCHE IL CARRELLO*/
		List<ArticleCart> articleCarts = articleCartRepository.findByIdIdCart(cart.getIdCart());
		if (articleCarts.isEmpty()){
			cartRepository.delete(cart);
			return StatusOrder.DELETE_SUCCESFULY;

		}
		/*SE CE NE SONO ANCORA ALLORA AGGIORNO IL PREZZO TOTALE*/
		cart.setTotalPrice(cart.getTotalPrice() - (article.getUnitPrice() * articleCart.getQtyOrdered()));
		cartRepository.save(cart);

		return StatusOrder.DELETE_SUCCESFULY;

	}

	@Transactional
	@Override
	public StatusOrder updateCart(int idUser, int idArticle, int qtyOrdered) {
		
		Optional<Cart> cartOpt = getCartByUserId(idUser);
		Cart cart = cartOpt.orElse(null);
		Article article = serviceArticle.getArticle(idArticle).get();
		
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
		
		serviceArticle.updateQtyAvailable(idArticle, qtyOrdered);
		
		return StatusOrder.ADDED_SUCCESSFULY;
	}

//	DA REFACTORZZARE !!!!!!!!1!!!1!!!!!!!!1!!!!!!!!!!
	@Transactional
	@Override
	public StatusOrder addCart(int idUser, int idArticle, int qtyOrdered) {
		
		Optional<Cart> cartOpt = cartRepository.findByUserIdUser(idUser);
		Cart cart = cartOpt.orElse(null);
		Article article = serviceArticle.getArticle(idArticle).get();
		
//		CONTROLLO LA QUANTITA DISPONIBILE DELL ARTICOLO
		if(!serviceArticle.checkQtyAvailable(idArticle, qtyOrdered)) {
			
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
			
			serviceArticle.updateQtyAvailable(idArticle, qtyOrdered);
			
			return StatusOrder.CREATED_SUCCESSFULY;
			
		}
//		SE ESISTE LO AGGIORNO
		
		return updateCart(idUser, idArticle, qtyOrdered);
		
		
	}

	public List<ArticleCart> getCartArticlesByCartId(int idCart) {
		
		return articleCartRepository.findByIdIdCart(idCart);
	}


}
