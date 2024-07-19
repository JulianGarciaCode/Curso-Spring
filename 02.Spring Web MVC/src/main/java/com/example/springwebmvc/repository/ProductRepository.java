package com.example.springwebmvc.repository;

import com.example.springwebmvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Extendemos de la clase JpaRepository y le indicamos la clase del beans que va a tomar y el tipo
de la variable del identificador de la clase
 */
@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
}
