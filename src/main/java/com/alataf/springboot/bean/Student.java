package com.alataf.springboot.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id= id;
        this.firstName=firstName;
        this.lastName=lastName;
    }
}