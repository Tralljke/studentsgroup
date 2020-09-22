package com.testwebapp.studentsgroup;

import com.testwebapp.studentsgroup.domain.Person;
import com.testwebapp.studentsgroup.domain.StudentsGroup;
import com.testwebapp.studentsgroup.repository.PersonRepository;
import com.testwebapp.studentsgroup.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StudentsgroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsgroupApplication.class, args);
    }
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private StudentsGroupRepository repository2;
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository repository;

 @PostConstruct
    public void init() {
    repository2.save(new StudentsGroup("15-15",9));
    repository2.save(new StudentsGroup("15-16", 10));
     repository2.save(new StudentsGroup("15-17", 0));
     repository2.save(new StudentsGroup("15-18", 22));
     repository2.save(new StudentsGroup("15-19", 3));
     repository2.save(new StudentsGroup("15-20", 11));

     repository.save(new Person("Иванов Иван","15-15" ));
     repository.save(new Person("Петр Иван","15-15"));
     repository.save(new Person("Кирилл Иван","15-15"));
     repository.save(new Person("Алексаднр Иван","15-15"));
     repository.save(new Person("Дауни Иван","15-15"));
     repository.save(new Person("Чича Иван","15-15"));
    }
}
