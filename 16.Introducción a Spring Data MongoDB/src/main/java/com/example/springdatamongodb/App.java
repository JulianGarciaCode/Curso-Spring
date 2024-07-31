package com.example.springdatamongodb;

import com.example.springdatamongodb.entity.Employee;
import com.example.springdatamongodb.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repo = context.getBean(EmployeeRepository.class);

        //Borramos datos, por si los hubiera
        repo.deleteAll();

        List<Employee> employees = List.of(
                new Employee(null, "JulianGarciaCode", "JulianGarciaCode@gmail.com", LocalDate.of(1990, 12, 31)),
                new Employee(null, "emp1", "emp1@gmail.com", LocalDate.of(1991, 9, 28)),
                new Employee(null, "emp2", "emp2@gmail.com", LocalDate.of(2000, 2, 15)),
                new Employee(null, "emp3", "emp3@gmail.com", LocalDate.of(1995, 8, 1)),
                new Employee(null, "emp3", "emp3@gmail.com", LocalDate.of(1995, 8, 1))

        );

        repo.saveAll(employees);

        repo.findAll().forEach(System.out::println);

        System.out.println("count: " + repo.countAllByName("emp3"));
        System.out.println("count: " + repo.countAllByNameQuery("emp3"));

        var mongo = context.getBean(MongoTemplate.class);
        Employee employee = new Employee(null, "emp4", "emp4@gmail.com", LocalDate.of(1998, 8, 1));
        mongo.save(employee);
//      repo.save(employee);


//      Formas de trabajar en MongoDB:
//        Query query = new Query();
//        query.addCriteria(Criteria.where());
//        mongo.findAndModify();
    }
}
