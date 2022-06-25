package com.serasa.desafio.Desafio.Covid.Serasa.service;

import java.util.List;


import com.serasa.desafio.Desafio.Covid.Serasa.model.Person;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(Long personId);
    void deletePersonById(Long personId);
}

