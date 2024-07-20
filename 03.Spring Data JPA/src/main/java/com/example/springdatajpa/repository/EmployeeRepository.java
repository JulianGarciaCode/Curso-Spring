package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/*
No es obligatorio usar @Repository, aunque si recomendable, ya que
al extender de JpaRepository  nuestra interazno hace falta
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*
    Optional solo devuelve 1, asegurarnos que no hay más dato con otro valor
    ej: DNI, matrícula
     */
    Optional<Employee> findByFullName(String fullName);
    Optional<Employee> findByFullNameAndBirthDate(String fullName, LocalDate birthDate);
    List<Employee> findAllByBirthDateAfter(LocalDate birthDate);
    List<Employee> findAllByBirthDateBetween(LocalDate min, LocalDate max);
   /*
   Spring nos detecta las variables de clase y podemos usar Métodos
   creados por Spring sin tener que implementarlos automáticamente
   para trabajar con ellos
    */
    List<Employee> findAllByMarriedTrue();
    List<Employee> findAllByMarriedFalse();
}
