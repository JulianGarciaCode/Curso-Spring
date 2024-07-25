package com.example.springpaginationrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET http://localhost:8080/api/employees
    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(this.employeeRepository.findAll());
    }

    /*
    GET http://localhost:8080/api/employees/sorted?sort=id,desc
    GET http://localhost:8080/api/employees/sorted?sort=name,desc
    GET http://localhost:8080/api/employees/sorted?sort=name,desc&sort=salary,asc
     */
    @GetMapping("/sorted")
    public ResponseEntity<List<Employee>> findAllSorted(@RequestParam(defaultValue = "id,desc") String[] sort){
        List<Order> orders = extractOrders(sort);
        return ResponseEntity.ok(this.employeeRepository.findAll(Sort.by(orders)));
    }

    /*
    GET http://localhost:8080/api/employees/paged
    GET http://localhost:8080/api/employees/paged?page=0&size=3&sort=name,desc
    GET http://localhost:8080/api/employees/paged?page=1&size=2&sort=name,desc&sort=salary,asc
     */
    @GetMapping("/paged")
    public ResponseEntity<List<Employee>> findAllPagedAndSorted(
            @RequestParam(defaultValue = "id,desc") String[] sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Order> orders = extractOrders(sort);
        var pageable = PageRequest.of(page, size, Sort.by(orders));
        Page<Employee> employeesPage = this.employeeRepository.findAll(pageable);
        return ResponseEntity.ok(employeesPage.getContent());
    }

    /*
    GET http://localhost:8080/api/employees/paged/info?sort=id,desc
    GET http://localhost:8080/api/employees/paged/info?sort=name,desc
    GET http://localhost:8080/api/employees/paged/info?sort=name,desc&sort=salary,asc
     */
    @GetMapping("/paged/info")
    public ResponseEntity<Map<String, Object>> findAllPagedAndSortedInfo(
            @RequestParam(defaultValue = "id,desc") String[] sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Order> orders = extractOrders(sort);
        var pageable = PageRequest.of(page, size, Sort.by(orders));
        Page<Employee> employeesPage = this.employeeRepository.findAll(pageable);
        var pageInfo = Map.of(
                "employees", employeesPage.getContent(),
                "currentPage", employeesPage.getNumber(),
                "totalItems", employeesPage.getTotalElements(),
                "totalPages", employeesPage.getTotalPages()
        );
        return ResponseEntity.ok(pageInfo);
    }

    /*
        solo un order:
        [0]: id
        [1]: desc

        múltiples orders
        [0]:id, desc
        [1]: name, asc
        [2]: email,desc
     */
    private List<Order> extractOrders(String[] sort){
        if(sort[0].contains((",")))
            return Arrays.stream(sort).map(pair -> extractOrder(pair)).toList();

        return List.of(extractOrder(sort[0] + "," + sort[1]));
    }

    private Order extractOrder(String sort){
        System.out.println(sort);
        String[] pair = sort.split(",");
        String field = pair[0];
        Direction direction = pair[1].equalsIgnoreCase("asc") ? Direction.ASC : Direction.DESC;
        return new Order(direction, field);
    }

}
