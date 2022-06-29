package com.serasa.desafio.Desafio.Covid.Serasa.controller;
import java.util.List;
import com.serasa.desafio.Desafio.Covid.Serasa.model.Person;
import com.serasa.desafio.Desafio.Covid.Serasa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id){
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return ResponseEntity.ok().body(this.personService.createPerson(person));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person person){
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updatePerson(person));
    }

    @DeleteMapping("/persons/{id}")
    public HttpStatus deletePerson(@PathVariable String id){
        this.personService.deletePersonById(id);
        return HttpStatus.OK;
    }
}
