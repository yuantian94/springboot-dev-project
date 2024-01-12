package com.restproject.demo.rest;

import com.restproject.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Mike","Tian"));
        theStudents.add(new Student("Jingyan","Huang"));
        theStudents.add(new Student("Niuniu","Tian"));

        return theStudents;
    }
}
