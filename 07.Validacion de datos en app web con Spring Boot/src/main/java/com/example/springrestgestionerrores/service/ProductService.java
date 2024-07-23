package com.example.springrestgestionerrores.service;

import com.example.springrestgestionerrores.entity.Product;

public interface ProductService {

    Product findById(Long id);
    Product save(Product product);
    Product deleteById(Long id);

}
