package com.spring.jdbc.demo.repo.impl;

import com.spring.jdbc.demo.model.Student;
import com.spring.jdbc.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentrepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Student student) {
        System.out.println("Entered into save() :::::: service impl");
        return jdbcTemplate.update("INSERT INTO student (name, city, birthdate) VALUES (?, ?, ?)",
                new Object[] {
                        student.getName(),
                        student.getCity(),
                        student.getBirthdate()
                });
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public Student findById(Long id) {
        try {
            Student student =  jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?", BeanPropertyRowMapper.newInstance(Student.class), id);
            return student;
        } catch(IncorrectResultSetColumnCountException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM student", BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
