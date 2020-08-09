package com.example.views.clientsideformbinding;

import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * The endpoint for the client-side view.
 */
@Endpoint
@AnonymousAllowed
public class PersonEndpoint {
    private final PersonService service;

    public PersonEndpoint(@Autowired PersonService service) {
        this.service = service;
    }

    public Person loadPerson() {
        return service.loadPerson();
    }

    public void savePerson(Person person) {
        service.savePerson(person);
    }
}
