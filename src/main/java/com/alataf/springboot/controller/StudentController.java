package com.alataf.springboot.controller;

import com.alataf.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    //Spring boot REST API with Path variable
    // {id} - URI template variable
    // whenever you've same variableName in URI and method variable then no need to specify variable name inside @PathVariable
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    //Spring boot REST API with Request Param
    // http://localhost:8080/student/query?id={id_value_given_user}
    // http://localhost:8080/student/query?id=89&first-name=robert&last-name=broon
    @GetMapping("/student/query")
    public Student studentRequestParam(@RequestParam("id") int studentId,
                                       @RequestParam("first-name") String firstName,
                                       @RequestParam("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

}
