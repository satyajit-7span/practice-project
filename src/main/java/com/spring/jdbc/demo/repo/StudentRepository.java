package com.spring.jdbc.demo.repo;

import com.spring.jdbc.demo.model.Student;

import java.util.List;

public interface StudentRepository {

    int save(Student student);

    int update(Student student);

    Student findById(Long id);

    int deleteById(Long id);

    List<Student> findAll();

    int deleteAll();

}
