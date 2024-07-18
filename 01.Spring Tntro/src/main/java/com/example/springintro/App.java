package com.example.springintro;

import com.example.springintro.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
Aunque ya viene autoconfigurado por defecto y no permite escanear paquetes fuera,
con @ComponentScan podemos escaner estos paquetes, aunque no es lo recomendado.
*/

@SpringBootApplication
@ComponentScan({"com.example.springintro", "com.example2.springintro"})
public class App {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(App.class, args);

        var employeeController = context.getBean(EmployeeController.class);
        System.out.println(employeeController.helloFromEmployeeService());
        System.out.println(employeeController.helloFromCustomerService());

    }
}
