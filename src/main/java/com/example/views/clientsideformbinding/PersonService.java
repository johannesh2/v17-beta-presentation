package com.example.views.clientsideformbinding;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class PersonService {

    private Person p = new Person();
    {
        p.setFirst("Johannes");
        p.setLast("H");
        p.setDateOfBirth(LocalDate.of(1982, 8, 10));
    }


    public void savePerson(Person p) {
        this.p = p;
    }

    public Person loadPerson() {
        return p;
    }
}
