package com.testwebapp.studentsgroup.repository;

import com.testwebapp.studentsgroup.domain.StudentsGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsGroupRepository extends CrudRepository<StudentsGroup, Integer> {
    List<StudentsGroup> findAll();
    StudentsGroup findByGroupnumber(String groupnumber);
}
