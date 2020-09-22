package com.testwebapp.studentsgroup.repository;

import com.testwebapp.studentsgroup.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findBySGroup(String sGroup);
}
