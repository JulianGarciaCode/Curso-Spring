package com.example.gestionerroreswebapp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Product {

    private Long id;

    @Size(min = 10, max = 100)
    @NotNull(message = "Título de producto no puede ser nulo")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Fecha de producto no puede ser nulo")
    private LocalDate released;

    @Min(value = 5)
    @NotNull(message = "Precio de producto no puede ser nulo")
    private Double price;

    public Product() {
    }

    public Product(Long id, String title, LocalDate released, Double price) {
        this.id = id;
        this.title = title;
        this.released = released;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", released=" + released +
                ", price=" + price +
                '}';
    }
}
