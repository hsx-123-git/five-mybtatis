package com.offcn.service.impl;

import com.offcn.dao.StudentMapper;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findByStudentQuery(Student student) {
        return studentMapper.findByStudentQuery(student);
    }

    @Override
    public boolean save(Student student) {
        return studentMapper.save(student)>0;
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.update(student)>0;
    }

    @Override
    public boolean delete(int id) {
        return studentMapper.delete(id)>0;
    }
}
