package com.example.springdataredis;

import com.example.springdataredis.domain.Employee;
import com.example.springdataredis.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(App.class, args);
        var repo= context.getBean(EmployeeRepository.class);
        List<Employee> employees = List.of(
                new Employee(null, "JulianGarciaCode", 20, LocalDate.of(1999, 1, 1)),
                new Employee(null, "emp1", 21, LocalDate.of(1994, 3, 23)),
                new Employee(null, "emp2", 30, LocalDate.of(2000, 12, 22)),
                new Employee(null, "emp3", 40, LocalDate.of(2010, 2, 15)),
                new Employee(null, "emp4", 23, LocalDate.of(2010, 2, 15)),
                new Employee(null, "emp5", 23, LocalDate.of(2010, 2, 15)),
                new Employee(null, "emp6", 23, LocalDate.of(2010, 2, 15)),
                new Employee(null, "emp7", 23, LocalDate.of(2010, 2, 15))
        );

        repo.saveAll(employees);


//        repo.findAll().forEach(System.out::println);

//        repo.findAll().forEach(employee -> {
//            repo.findById(employee.getId());
//        });
        repo.findById("2fbc83e4-983f-4322-827d-498cf22a9d55").ifPresent(System.out::println);
        repo.findTop3ByAge(23).forEach(System.out::println);
        //var redis = context.getBean(RedisTemplate.class);

    }
}
