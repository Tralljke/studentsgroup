package com.petrbel.studentsgroup.repository;

import com.petrbel.studentsgroup.domain.StudentsGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentsGroupRepositoryTest {

    @Autowired
    StudentsGroupRepository repository;

    static final long QUANTITY = 3;

    @Test
    void findByGroupNumber() {
        StudentsGroup studentsGroup = repository.findByGroupNumber("15-31");

        Assertions.assertEquals(QUANTITY, studentsGroup.getQuantity());

    }
}