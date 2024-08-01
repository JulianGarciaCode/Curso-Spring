package com.example.springtimeout;
//record es como una clase de java pero más abreviada, no recomenadle
//para bases de datos o si la clase cambia, pero sí para DTO's o ResultSets
//se pasa por parametros las variables y crea los constructores, geters y seters.
public record Employee(Long id, String name, Double salary) {
}
