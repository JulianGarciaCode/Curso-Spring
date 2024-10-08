package org.example.springevents.controller;

import org.example.springevents.model.Employee;
import org.example.springevents.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable Long id) {
        service.deleteById(id);
    }
}
