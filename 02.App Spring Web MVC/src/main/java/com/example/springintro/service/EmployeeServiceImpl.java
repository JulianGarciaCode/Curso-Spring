package com.example.springintro.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Elegimos unos de los dos o @Service o @Component(más genérico) ambos a la vez no
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String hello(){
        return "Hola mundo";
    }
}
