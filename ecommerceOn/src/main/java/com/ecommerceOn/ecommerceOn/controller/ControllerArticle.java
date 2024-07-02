package com.ecommerceOn.ecommerceOn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceOn.ecommerceOn.model.Article;
import com.ecommerceOn.ecommerceOn.service.ServiceArticle;


@RestController
@RequestMapping("ecommerceOn")
public class ControllerArticle {

	@Autowired
	private ServiceArticle serviceArticle;
	
	@GetMapping(value="article/{id_article}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getArticle(@PathVariable("id_article") String idArticle){
		
		 Optional<Article> articleOpt = serviceArticle.getArticle(idArticle);
		
		if(!articleOpt.isPresent()) {
			
			return new ResponseEntity<>(articleOpt.get(), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(articleOpt.get(), HttpStatus.OK);
		
		
	}
	
	@GetMapping(value="articles", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllArticles(){
		
		 List<Article> articles = serviceArticle.getAllArticles();
		
		
		return new ResponseEntity<>(articles, HttpStatus.OK);
		
		
	}
	
}
