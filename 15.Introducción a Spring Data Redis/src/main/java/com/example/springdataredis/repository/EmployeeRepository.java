package com.example.springdataredis.repository;

import com.example.springdataredis.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findTop3ByAge(Integer age);
}


