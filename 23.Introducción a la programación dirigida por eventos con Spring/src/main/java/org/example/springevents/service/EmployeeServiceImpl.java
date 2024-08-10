package org.example.springevents.service;

import org.example.springevents.event.EmployeeEventPusblisher;
import org.example.springevents.model.Employee;
import org.example.springevents.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeEventPusblisher publisher;

    @Override
    public Employee create(Employee employee) {
        /*
        De esta forma si cambia la API de Spring nos oblgaria a
        cambiar las clases para adaptarlo
        return repository.save(employee);

        De la siguiente manera nos evitamos tener que modificar
        varias clases, solamente en la clase Event que trabaja
        con la API de Spring
         */

        repository.save(employee);
        publisher.publishCreateEvent(employee);
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        if(!repository.existsById(id)) {
            publisher.publishDeleteEvent(null);
            return;
        }
                    ;
        repository.findById(id).ifPresent(employee -> {
        repository.deleteById(id);
        publisher.publishDeleteEvent(employee);
    });
    }
}
