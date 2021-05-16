package com.offcn.dao;

import com.offcn.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();

    Student findById(int id);

    List<Student> findByStudentQuery(Student student);

    int save(Student student);

    int update(Student student);

    int delete(int id);

}
