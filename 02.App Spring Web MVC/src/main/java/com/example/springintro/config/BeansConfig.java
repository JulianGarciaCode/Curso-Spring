package com.example.springintro.config;

import com.example.springintro.primary.CustomerAServiceImpl;
import com.example.springintro.primary.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*Con la anotacion @Configuration es otra forma de declarar estructura de beans
usando un archivo XML, en lugar de @Service o @Qualifier.
*/
@Configuration
@ImportResource("classpath:beans.xml")
public class BeansConfig {

    /*
    Esta opción se utiliza para configurar clases que provienen de frameworks externos usando @Bean .
    */
    //@Bean
    public CustomerService customerService(){
        return new CustomerAServiceImpl();
    }

}
