package com.spring.jdbc.demo.controller;

import com.spring.jdbc.demo.model.Student;
import com.spring.jdbc.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jdbc/api")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try {
            repository.save(new Student(student.getName(), student.getCity(), student.getBirthdate()));
            return new ResponseEntity<>("Student saved successfully...!!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Student> findAll() {
        System.out.println("Entered into findAll() into StudentController...!!");
        return repository.findAll();
    }

    @GetMapping
    public List<Student> findAllStudentById(@PathVariable("id") long id) {
        Student student = repository.findById(id);
        System.out.println("Entered into findAllStudentById() into StudentController...!!");
        return repository.findAll();
    }
}
