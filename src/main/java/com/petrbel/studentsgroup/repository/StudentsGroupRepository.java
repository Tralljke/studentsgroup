package com.petrbel.studentsgroup.repository;

import com.petrbel.studentsgroup.domain.StudentsGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface StudentsGroupRepository extends CrudRepository<StudentsGroup, Integer> {

    Page<StudentsGroup> findAll(Pageable pageable);

    StudentsGroup findByGroupNumber(String groupNumber);
}
