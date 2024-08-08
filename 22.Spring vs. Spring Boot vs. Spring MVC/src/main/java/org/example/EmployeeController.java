package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
Para usar @Controller basta con la dependecia context, pero para
usar @RestController necesitamos añadir el reposito web MVC de spring
 */
@Controller
//@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
