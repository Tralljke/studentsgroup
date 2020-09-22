package com.testwebapp.studentsgroup.rest;

import com.testwebapp.studentsgroup.domain.Person;
import com.testwebapp.studentsgroup.domain.StudentsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.testwebapp.studentsgroup.repository.PersonRepository;
import com.testwebapp.studentsgroup.repository.StudentsGroupRepository;
import com.testwebapp.studentsgroup.domain.StudentsGroup;

import java.util.List;

@Controller
public class StudentsGroupController {
    private final StudentsGroupRepository repository2;

    @Autowired
    public StudentsGroupController(StudentsGroupRepository repository2) {
        this.repository2 = repository2;
    }

    @GetMapping("/")
    public String listPage(Model model ) {

        List<StudentsGroup> groups = repository2.findAll();
        model.addAttribute("sGroups", groups);
        return "view";
    }
    @PostMapping()
    public String add(@RequestParam String text,Model model){
        StudentsGroup studentsGroup = new StudentsGroup(text,0);
        repository2.save(studentsGroup);
        return "edit";
    }

}
