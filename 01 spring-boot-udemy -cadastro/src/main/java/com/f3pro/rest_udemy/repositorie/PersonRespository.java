package com.f3pro.rest_udemy.repositorie;

import com.f3pro.rest_udemy.modal.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends JpaRepository<Person, Long> {
}
