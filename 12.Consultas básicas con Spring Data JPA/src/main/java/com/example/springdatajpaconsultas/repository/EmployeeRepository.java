package com.example.springdatajpaconsultas.repository;

import com.example.springdatajpaconsultas.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   Optional<Employee> findByEmail(String email);
   List<Employee>findByAgeIn(List<Integer> ages);
   List<Employee> findByAgeBetween(Integer min, Integer max);
   List<Employee> findByAge(Integer age);
   List<Employee> findByAgeOrderByFirstNameDesc(Integer age);
   Long countByAgeAfter(Integer age);

   @Query(value = "SELECT e FROM Employee e WHERE e.age IN :ages")
    List<Employee> findByAgeInQuery(@Param("ages") List<Integer> edades);
    //List<Employee> findByAgeInQuery(List<Integer> ages);

    //Los bloque de texto del query @Query(""".../salto linea...""") Disponible desde la veri´son1 5
    //El lenguaje de DB es JPQL
    @Query("""
        SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END
        FROM Employee e
        WHERE lower(e.firstName) LIKE lower(:firstName) 
    """)
    boolean existsByEmailLikeQuery(String firstName);


    @Query(value = "SELECT * FROM employees e WHERE e.married = true", nativeQuery = true)
    List<Employee> findAllByMarriedTrueQuery();

    //Usar @Modifying para modificar con consultas.
    //En este caso modifica married=False si birthdate > que el que pasemos
    //Para transcacciones habría que añadir @Transactional
    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.married = false WHERE e.birthDate > :birthDate")
    void updateMarriedToFalseByBirthDateAfterQuery(@Param("birthDate") LocalDate birthDate);
}