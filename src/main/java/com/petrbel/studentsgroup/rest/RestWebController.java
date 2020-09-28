package com.petrbel.studentsgroup.rest;

import com.petrbel.studentsgroup.domain.Person;
import com.petrbel.studentsgroup.domain.Response;
import com.petrbel.studentsgroup.domain.StudentsGroup;
import com.petrbel.studentsgroup.repository.PersonRepository;
import com.petrbel.studentsgroup.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    private final PersonRepository personRepository;
    private final StudentsGroupRepository groupRepository;

    @Autowired
    public RestWebController(PersonRepository personRepository, StudentsGroupRepository groupRepository) {
        this.personRepository = personRepository;
        this.groupRepository = groupRepository;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Response deleteResource(@PathVariable int id, Model model) {
        Person s = personRepository.findById(id);
        StudentsGroup studentsGroup = groupRepository.findByGroupNumber(s.getGroupNumber());
        studentsGroup.deductQuantity();
        personRepository.delete(s);
        List<Person> persons = personRepository.findByGroupNumberOrderByName(s.getGroupNumber());
        model.addAttribute("groupNum",s.getGroupNumber());
        Response response = new Response("Done", persons);
        return response;
    }

    @PostMapping(value = "/save")
    public Response savePerson(@RequestBody Person person) {
        String name = person.getName();
        String groupNumber = person.getGroupNumber();
        StudentsGroup studentsGroup = groupRepository.findByGroupNumber(groupNumber);
        studentsGroup.addQuantity();
        groupRepository.save(studentsGroup);
        Person gaga = new Person(name,groupNumber);
        personRepository.save(gaga);
        List<Person> persons = personRepository.findByGroupNumberOrderByName(groupNumber);
        Response response = new Response("Done", persons);
        return response;
    }
}
