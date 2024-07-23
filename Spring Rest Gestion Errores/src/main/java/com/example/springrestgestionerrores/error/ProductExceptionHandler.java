package com.example.springrestgestionerrores.error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
Con @Order indicamos la prioridad de carga de
este Handler, de los Handlers/restControllers
del proyecto, y con Ordered.HIGHEST_PRECEDENCE
le indicamos que capture las excepciones de la
clase ProductExceptionHandler antes que el
GlobalExceptionHandle.
Cuando cargue las excepciones globales ya tendrá
cargada la gestion de errores de la clase especifica
que hemos creado ProductExceptionHander, de lo contrario
no podría manejar excepciones de clase Producto y daría
error en la ejecución.
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ProductExceptionHandler {


}
