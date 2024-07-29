package com.example.springrestgestionerrores.controller;

import com.example.springrestgestionerrores.entity.Product;
import com.example.springrestgestionerrores.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public Product save(@RequestBody @Valid Product product){
        return service.deleteById(1L);
    }

}
