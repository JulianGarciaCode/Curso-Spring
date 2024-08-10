package org.example.springevents.service;

import org.example.springevents.model.Employee;

public interface EmployeeService {

    Employee create(Employee employee);
    void deleteById(Long id);


}
