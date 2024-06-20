package com.alataf.springboot.controller;

import com.alataf.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "robert", "broon");
        return student;
    }

    @GetMapping("/student-list")
    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "robert", "broon"));
        studentList.add(new Student(2, "richard", "wes"));
        studentList.add(new Student(3, "daven", "key"));
        studentList.add(new Student(4, "mitchell", "starch"));
        studentList.add(new Student(5, "wane", "killson"));

        return studentList;
    }

}
