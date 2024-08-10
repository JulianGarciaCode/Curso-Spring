package org.example.springevents.event;

import org.example.springevents.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/*
En esta clase emitimos los eventos y capturamos en logs para
poder tratarlos más adelante
 */
@Component
public class EmployeeEventPusblisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publishCreateEvent(Employee employee){
        var event = new EmployeeEvent(employee, "Created employee");
        publisher.publishEvent(event);
    }

    public void publishDeleteEvent(Employee employee){
        var event = new EmployeeEvent(employee, "Deleted employee");
        publisher.publishEvent(event);
    }

    public void publishNotFoundEvent(){
        var event = new EmployeeEvent(null, "Employee not found");
        publisher.publishEvent(event);
    }
}
