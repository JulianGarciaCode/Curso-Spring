package com.example.springrestgestionerrores.entity;

import jakarta.validation.constraints.NotNull;

public class Manufacturer {

    @NotNull(message = "Nombre obligatorio")
    private String name;
    private int year;

    public Manufacturer() {
    }

    public Manufacturer(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
