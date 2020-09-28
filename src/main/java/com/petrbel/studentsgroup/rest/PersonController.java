package com.petrbel.studentsgroup.rest;

import com.petrbel.studentsgroup.repository.PersonRepository;
import com.petrbel.studentsgroup.domain.Person;
import com.petrbel.studentsgroup.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PersonController {

    private final PersonRepository personRepository;
    private final StudentsGroupRepository groupRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, StudentsGroupRepository groupRepository) {
        this.personRepository = personRepository;
        this.groupRepository = groupRepository;
    }
    @GetMapping("/edit")
    String testPage(@RequestParam("groupNumber") String groupNumber, Model model)
    {
        List<Person> persons = personRepository.findByGroupNumberOrderByName(groupNumber);
        model.addAttribute("gNum",groupNumber);
        model.addAttribute("person", persons);
        return "edit";
    }
}
