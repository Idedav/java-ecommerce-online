package com.ecommerceOn.ecommerceOn.config;

import com.ecommerceOn.ecommerceOn.exception.CartNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleCartNotFoundException(HttpServletRequest request, CartNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Il carrello non esiste per l'utente specificato.");
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", ex);
        modelAndView.setViewName("app.exception"); // Specifica la vista per l'errore
        return modelAndView;
    }
}

