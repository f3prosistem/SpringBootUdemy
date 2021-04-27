package com.f3pro.rest_udemy.controller;

import com.f3pro.rest_udemy.data.vo.PersonVO;
import com.f3pro.rest_udemy.services.PersonServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
@Api(value = " Person Endponit", description = "Descrição de Pessoas", tags = "PersonEndPoint")
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @ApiOperation(value = "listar todas as pessoas")
    @GetMapping(produces = {"application/json", "application/xml"})
    public List<PersonVO> findAll() {
       List<PersonVO>persons = service.findAll();
       persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
       return persons;

    }

    @ApiOperation(value = "listar pessoa por Id")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public PersonVO findById(@PathVariable("id") Long id) {
        PersonVO personVO =service.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }
    @ApiOperation(value = "Cadastar um nova pessoa")
    @PostMapping(produces = {"application/json", "application/mxl"},
            consumes = {"application/json", "application/xml"})
    public PersonVO create(@RequestBody PersonVO person) {
        PersonVO personVO = service.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "atualizar uma pessoa")
    @PutMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public PersonVO update(@RequestBody PersonVO person) {
        PersonVO personVO = service.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return personVO;
    }
    @ApiOperation(value = "Deletar Pessoa passado um Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}