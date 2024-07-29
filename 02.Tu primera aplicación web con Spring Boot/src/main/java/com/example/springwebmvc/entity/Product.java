package com.example.springwebmvc.entity;

import jakarta.persistence.*;
/*
Con @entity indicamos que es un beans para que pueda usarlo en otros frameworks.
Con @Table, indicamos que va a ser tratada también como una tabla de base de datos para JPA.
 */
@Entity
@Table(name = "products")
public class Product {

    /*
    @Id sobre private Long id, indicamos que va a ser el identificador de nuestros objetos.
    @GeneratedValue nos genera automáticamente el id de los objetos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double price;

    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String title, Double price, Integer quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
