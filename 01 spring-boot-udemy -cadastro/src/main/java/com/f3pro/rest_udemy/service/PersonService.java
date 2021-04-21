package com.f3pro.rest_udemy.service;

import com.f3pro.rest_udemy.Expection.ResourceNotFoundException;
import com.f3pro.rest_udemy.modal.Person;
import com.f3pro.rest_udemy.repositorie.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRespository respository;

    public Person create(Person person) {
        return respository.save(person);
    }

    public Person findById(Long id) {
        return respository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum Id encontrado!"));

    }

    public List<Person> findAll() {
        return respository.findAll();
    }

    public Person update(Person obj) {

        Person entity = findById(obj.getId());

        entity.setFirstName(obj.getFirstName());
        entity.setLastName(obj.getLastName());
        entity.setAddress(obj.getAddress());
        entity.setGender(obj.getGender());
        return respository.save(entity);

    }

    public void delete(Long id) {
        Person entity = findById(id);
        respository.delete(entity);
    }
}
