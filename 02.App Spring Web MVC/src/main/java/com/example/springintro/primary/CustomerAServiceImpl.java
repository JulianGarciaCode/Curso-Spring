package com.example.springintro.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
-Al usar el archivo BeansConfig, con clase @Configuration y @Bean a nivel
de método para declarar los beans de spring ya no necesitamos las anotaciones
@Primary ni @Service para indicar los beans a spring.
-@Primary Hace que al declarar una clase elija CustomerAService, de lo contrario da error.
-@Qualifier es otra opción, cuando se va inyectar el beans se le indica el @Qualifier
*/

//@Primary
//@Service
public class CustomerAServiceImpl implements CustomerService {
    @Override
    public String hello() {
        return "Hola desde cliente A";
    }
}
