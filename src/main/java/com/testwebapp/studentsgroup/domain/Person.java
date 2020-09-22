package com.testwebapp.studentsgroup.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String data;
    @NotNull
    private String name;
    @NotNull
    private String SGroup;


    public Person() {
    }

    public String getsGroup() {
        return SGroup;
    }

    public void setsGroup(String SGroup) {
        this.SGroup = SGroup;
    }

    public Person( String name, String SGroup) {
        this.data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        this.name = name;
        this.SGroup = SGroup;
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
