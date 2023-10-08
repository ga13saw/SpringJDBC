package com.spring.jdbc.dao;

import com.spring.jdbc.model.entities.Student;

import java.util.List;

public interface StudentDao {

    int insert(Student student);
    int update(Student student);
    int delete(int id);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
