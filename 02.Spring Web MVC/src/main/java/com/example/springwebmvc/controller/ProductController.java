package com.example.springwebmvc.controller;

import com.example.springwebmvc.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {


    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }
    /*
    GET http://localhost:8080/products
     */
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("product", "Hola mundo");
        return "product-list";
    }

}
