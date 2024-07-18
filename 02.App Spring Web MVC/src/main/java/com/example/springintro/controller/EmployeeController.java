package com.example.springintro.controller;

import com.example.springintro.primary.CustomerService;
import com.example.springintro.service.EmployeeService;
import com.example2.springintro.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    /*
    Autowired (es la opción de inyectar beans más rápida), a nivel de método setter,
    a nivel de constructor (es la opción más recomendada para inyectar ya que
    facilita el testing) y otra opción sería usando @Qualifier.
     */
    //@Autowired
    private EmployeeService employeeService;

    //@Autowired
    private CustomerService customerService;
    /*
    Otra opción de inyectar beans es utilizar @Qualifier("customerAServiceImpl")
    */
    //@Autowired
    private HelloService helloService;

    /*
        Con el constructor es la mejor forma de inyectar beans
     */
    public EmployeeController(EmployeeService employeeService, CustomerService customerService, HelloService helloService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.helloService = helloService;
    }

    public String helloFromEmployeeService(){
        return this.employeeService.hello();
    }

    public String helloFromCustomerService(){
        return this.customerService.hello();
    }
}
