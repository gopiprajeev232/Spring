package com.spring.restpractice.controller;

import com.spring.restpractice.classes.Student;
import com.spring.restpractice.classes.StudentNotFoundException;
import com.spring.restpractice.errorresponse.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student(1, "Gopi", "Prajeev", true));
        students.add(new Student(2, "Pavan", "Ganesh", true));
        students.add(new Student(3, "Krishna", "Chaitanya", true));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: "+studentId);
        }

        return students.get(studentId);
    }
}
