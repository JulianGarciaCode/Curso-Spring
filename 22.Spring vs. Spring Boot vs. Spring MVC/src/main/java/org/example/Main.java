package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    //Añadimos el ApplicationContext para que lea el beans.XML con la configuración
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        var controller = context.getBean(EmployeeController.class);
        controller.findAll().forEach(System.out::println);
    }
}