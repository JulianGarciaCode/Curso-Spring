package com.example.springrestgestionerrores.service;

import com.example.springrestgestionerrores.entity.Product;
import com.example.springrestgestionerrores.error.ProductTitleException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product findById(Long id) {
        throw new NoSuchElementException("Producto no encontrado");
    }

    @Override
    public Product save(Product product) {
        throw new ProductTitleException(product);
    }

    @Override
    public Product deleteById(Long id) {
        throw new NullPointerException("Error al intentar borrar producto");
    }
}
