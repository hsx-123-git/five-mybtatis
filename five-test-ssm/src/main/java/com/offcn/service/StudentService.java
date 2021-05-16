package com.offcn.service;

import com.offcn.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    List<Student> findByStudentQuery(Student student);

    boolean save(Student student);

    boolean update(Student student);

    boolean delete(int id);

}
