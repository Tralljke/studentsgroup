package com.testwebapp.studentsgroup.rest;

import com.testwebapp.studentsgroup.domain.Person;
import com.testwebapp.studentsgroup.domain.StudentsGroup;
import com.testwebapp.studentsgroup.repository.PersonRepository;
import com.testwebapp.studentsgroup.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class PersonController {

    private final PersonRepository repository;
    private final StudentsGroupRepository repository2;



    @Autowired
    public PersonController(PersonRepository repository,StudentsGroupRepository repository2) {
        this.repository = repository;
        this.repository2 = repository2;
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("sGroup") String sGroup, Model model) {
        List<Person> persons = repository.findBySGroup(sGroup);
        model.addAttribute("groupNum",sGroup);
        model.addAttribute("person", persons);
        return "edit";
    }
    @PostMapping("/edit")
    public String addNewPerson(@RequestParam("sGroup") String sGroup,@RequestParam String text,Model model)
    {
        StudentsGroup studentsGroup = repository2.findByGroupnumber(sGroup);
        studentsGroup.addQuantity();
        repository2.save(studentsGroup);
        Person person = new Person(text,sGroup);
        repository.save(person);
        List<Person> persons = repository.findBySGroup(sGroup);
        model.addAttribute("groupNum",sGroup);
        model.addAttribute("person", persons);
        return "edit";
    }
}
