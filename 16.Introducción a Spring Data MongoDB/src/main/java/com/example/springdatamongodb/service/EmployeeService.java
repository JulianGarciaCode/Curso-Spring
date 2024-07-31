/*
package com.example.springdatamongodb.service;

import com.example.springdatamongodb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

//Otra forma de Inyectar datos podría ser desde un service

@Service
public class EmployeeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String hello(){
        return mongoTemplate.getCollectionName(Employee.class);
    }
}
*/