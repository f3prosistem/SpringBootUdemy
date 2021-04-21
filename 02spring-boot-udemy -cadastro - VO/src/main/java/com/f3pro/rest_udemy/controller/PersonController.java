package com.f3pro.rest_udemy.controller;

import com.f3pro.rest_udemy.modal.PersonVO;
import com.f3pro.rest_udemy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PersonVO")
public class PersonVOController {

    @Autowired
    private PersonService services;

    @GetMapping
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable("id") Long id) {
        return services.findById(id);

    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO PersonVO) {
        return services.create(PersonVO);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO PersonVO) {
        return services.update(PersonVO);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.ok().build();

    }
}
