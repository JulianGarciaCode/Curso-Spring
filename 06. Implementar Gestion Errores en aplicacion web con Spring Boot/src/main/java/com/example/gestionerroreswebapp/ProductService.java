package com.example.gestionerroreswebapp;


public interface ProductService {

    Product findById(Long id);
    Product save(Product product);
    Product delete(Product product);


}
