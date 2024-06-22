package com.alataf.springboot.controller;

import com.alataf.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "robert", "broon");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "alataf")
                .body(student);
    }

    @GetMapping("/student-list")
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "robert", "broon"));
        studentList.add(new Student(2, "richard", "wes"));
        studentList.add(new Student(3, "daven", "key"));
        studentList.add(new Student(4, "mitchell", "starch"));
        studentList.add(new Student(5, "wane", "killson"));

        // return new ResponseEntity<>(studentList, HttpStatus.OK);
        return ResponseEntity.ok(studentList);
    }

    //Spring boot REST API with Path variable
    // {id} - URI template variable
    // whenever you've same variableName in URI and method variable then no need to specify variable name inside @PathVariable
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API with Request Param
    // http://localhost:8080/student/query?id={id_value_given_user}
    // http://localhost:8080/student/query?id=89&first-name=robert&last-name=broon
    @GetMapping("/student/query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam("id") int studentId,
                                       @RequestParam("first-name") String firstName,
                                       @RequestParam("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        // return ResponseEntity.ok(student);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    // Spring boot REST API that handles HTTP POST Request
    // @POST mapping , @RequestBody
    @PostMapping("/students/create")
    //@ResponseStatus(HttpStatus.CREATED) - now we're using inside responseEntity
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        // To check values in console, i used sout.
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
    // @PUT mapping, @RequestBody
    @PutMapping("/student/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable(value = "id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE request - to delete existing resource
    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable(value = "id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
