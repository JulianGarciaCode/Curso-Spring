package com.example.springrestopenapi.controller;

/*
Para crear un controlador oculto desde fuera
o privado que quede excluido de la documentación,
usamos la anotacion @Hidden para que oculte la clase en la documentación
 */

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class HiddenController {
}
