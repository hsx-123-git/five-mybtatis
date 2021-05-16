package com.offcn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/page")
    public PageInfo<Student> pageInfo(@RequestParam(value = "pageNum",required = false,defaultValue = "1")
                                                  int pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")
                                                    int pageSize, Student student){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> pageStudent = studentService.findByStudentQuery(student);
        PageInfo<Student> studentPageInfo = new PageInfo<>(pageStudent);
        return studentPageInfo;

    }

    @GetMapping("{sno}")
    public Student findById(@PathVariable Integer sno){
        return studentService.findById(sno);
    }

    @GetMapping("query")
    public List<Student> findByStudentQuery(@RequestBody Student student){
        return studentService.findByStudentQuery(student);
    }

    @PostMapping("save")
    public boolean save(@RequestBody Student student){
        return studentService.update(student);
    }

    @PostMapping("{sno}")
    public boolean delete(@PathVariable Integer sno){
        return studentService.delete(sno);
    }

}
