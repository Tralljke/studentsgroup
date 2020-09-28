package com.petrbel.studentsgroup.repository;

import com.petrbel.studentsgroup.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    static final String NAME = "Антон Дачный";


    @Test
    void findById() {
        Person testPerson = repository.findById(1177); ;

        Assertions.assertEquals(NAME, testPerson.getName());
    }

}