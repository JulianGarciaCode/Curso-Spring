package com.example.springdatajpaconsultas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private int age;

    @Column(unique = true)
    private String email;

    private boolean married;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Employee() {
    }

    public Employee(Long id, String firstName, int age, String email, Boolean married, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
        this.married = married;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", married=" + married +
                ", birthDate=" + birthDate +
                '}';
    }
}
