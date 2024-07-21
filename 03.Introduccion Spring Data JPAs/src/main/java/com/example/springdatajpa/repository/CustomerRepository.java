package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /*
    Método derivado en un repositorio Customer para buscar cliente,
    por id mayor que y el email.

    List findByidGreaterThanAndEmail(Long id, String email);

     */


}