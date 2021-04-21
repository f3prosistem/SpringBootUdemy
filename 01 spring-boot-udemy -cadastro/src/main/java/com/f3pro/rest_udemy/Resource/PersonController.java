package com.f3pro.rest_udemy.Resource;

import com.f3pro.rest_udemy.modal.Person;
import com.f3pro.rest_udemy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService services;

    @GetMapping
    public List<Person> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return services.findById(id);

    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Person> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.ok().build();

    }
}
