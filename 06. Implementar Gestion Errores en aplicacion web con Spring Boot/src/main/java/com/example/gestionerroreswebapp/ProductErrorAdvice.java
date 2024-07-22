package com.example.gestionerroreswebapp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ProductErrorAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ModelAndView handleNoSuchEx(NoSuchElementException ex){
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("message", ex.getMessage());
        modelView.setViewName("productError");
        return modelView;
    }

    @ExceptionHandler(value = ProductTitleException.class)
    public ModelAndView handleTitleEx(ProductTitleException ex){
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("message", "Problemas con el título: " + ex.getProduct().getTitle());
        modelView.setViewName("productError");
        return modelView;
    }

}
