package com.example.gestionerroreswebapp;

public class ProductTitleException extends RuntimeException {

    Product product;

    public ProductTitleException(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

}
