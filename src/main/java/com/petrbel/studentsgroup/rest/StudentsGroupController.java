package com.petrbel.studentsgroup.rest;

import com.petrbel.studentsgroup.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.petrbel.studentsgroup.domain.StudentsGroup;
import org.thymeleaf.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class StudentsGroupController {

    private final StudentsGroupRepository groupRepository;

    @Autowired
    public StudentsGroupController(StudentsGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/")
    public String listPage(Model model, @PageableDefault
            (size = 15,sort = { "id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<StudentsGroup> groups = groupRepository.findAll(pageable);

        model.addAttribute("sGroups", groups);
        setView(groups,model);

        return "view";
    }
    @PostMapping("/")
    public String addGroup(@RequestParam String groupNumber, Model model, @PageableDefault
            (size = 15,sort = { "id"}, direction = Sort.Direction.DESC)Pageable pageable) {

        if (StringUtils.isEmpty(groupNumber)) {
            model.addAttribute("message","Введите номер группы в поле");

            Page<StudentsGroup> groups = groupRepository.findAll(pageable);
            model.addAttribute("sGroups", groups);
            setView(groups,model);

            return "view";
        }

        StudentsGroup group = groupRepository.findByGroupNumber(groupNumber);
        if (group != null) {
            model.addAttribute("message","Группа " + groupNumber + " уже существует в таблице");

            Page<StudentsGroup> groups = groupRepository.findAll(pageable);
            model.addAttribute("sGroups", groups);
            setView(groups,model);

            return "view";
        }

        StudentsGroup studentsGroup = new StudentsGroup(groupNumber, 0);
        groupRepository.save(studentsGroup);

        return "redirect:/edit?groupNumber=" + groupNumber;

    }

    private void setView(Page<StudentsGroup> page, Model model) {

        int totalPages = page.getTotalPages();
        int currentPageNumber = page.getNumber();

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages - 1)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pages", pageNumbers);
        }
    }
}
