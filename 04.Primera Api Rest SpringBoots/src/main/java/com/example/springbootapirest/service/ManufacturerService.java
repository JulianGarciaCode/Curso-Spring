package com.example.springbootapirest.service;

import com.example.springbootapirest.entity.Manufacturer;

import java.util.List;
import java.util.Optional;

/*
CRUD:
Create
Retrieve/Read
Update
Delete
 */
public interface ManufacturerService {

    //RETREVE(Consultas)
    List<Manufacturer> findAll();
    List<Manufacturer> findAllbyYear(Integer year);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> findByName(String name);

    //CREATE / UPDATE
    Manufacturer save(Manufacturer manufacturer);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

    //Más lógicas de negocio:
    //1. Coches fabricados
    //2. Beneficios obtenidos
    //3. .....

}
