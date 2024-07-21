package com.example.springintro.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
Al usar el archivo BeansConfig, con clase @Configuration y @Bean a nivel
de método para declarar los beans de spring ya no necesitamos
las anotaciones @Primary ni @Service para indicar los beans a spring.
*/

//@Primary
//@Service
public class CustomerBServiceImpl implements CustomerService{

    @Override
    public String hello() {
        return "Hola desde cliente B";
    }
}
