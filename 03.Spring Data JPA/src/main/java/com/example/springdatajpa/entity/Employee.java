package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", unique = true)
    private String fullName;

    private LocalDate birthDate;

    private boolean married;


    public Employee() {
    }

    public Employee(Long id, String fullName, LocalDate birthDate, boolean married) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.married = married;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", married=" + married +
                '}';
    }
}
