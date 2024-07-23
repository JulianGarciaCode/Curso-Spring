package com.example.springrestgestionerrores.error;

import com.example.springrestgestionerrores.entity.Product;

public class ProductTitleException extends RuntimeException {
    private Product product;
    public ProductTitleException(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
