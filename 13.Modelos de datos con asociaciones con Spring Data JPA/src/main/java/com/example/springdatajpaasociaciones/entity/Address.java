package com.example.springdatajpaasociaciones.entity;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String postalCode;

    //Al igual que en la Employee, indicamos aqui que es una relacion 1to1, pero aquí indicamos que Address está dentro
    //de la clase Employee, indicando en la etiqueta @OneToOne(mappedBy = "address") nombre de la variable que la contiene en
    //la clase Contenedora, en este caso dentro de clase Employee, la clase Address se guarda dentro de la variable address.
    //Con FetchType.LAZY indicamos que no se carguen las asociaciones, a no ser que tu las cargues(tmb existe la opción contraria EAGER)
    //Bidireccional (Opcional)
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Employee employee;

    public Address() {
    }

    public Address(Long id, String street, String postalCode, Employee employee) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", employee=" + employee +
                '}';
    }
}
