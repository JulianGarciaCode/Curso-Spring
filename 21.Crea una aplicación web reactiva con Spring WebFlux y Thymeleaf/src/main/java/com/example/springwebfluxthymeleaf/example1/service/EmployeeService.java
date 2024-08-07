package com.example.springwebfluxthymeleaf.example1.service;

import com.example.springwebfluxthymeleaf.example1.model.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Random;
import java.util.stream.Stream;

@Service
public class EmployeeService {


    public Flux<Employee> findAll(){
        Random rand = new Random();
        return Flux.fromStream(
                Stream.generate(
                        () -> new Employee(rand.nextLong(), "empl" + rand.nextLong(), 60000.0)
                ).limit(30000)
        );
    }
}
