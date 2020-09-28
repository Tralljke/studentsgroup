package com.petrbel.studentsgroup.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String data;
    private String name;
    private String groupNumber;


    public Person() {
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Person( String name, String groupNumber) {
        this.data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
