package com.petrbel.studentsgroup.repository;

import com.petrbel.studentsgroup.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByGroupNumberOrderByName(String groupNumber);

    Person findById(int id);

    List<Person> findAll();
}
