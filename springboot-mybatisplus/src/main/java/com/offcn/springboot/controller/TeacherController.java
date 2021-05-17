package com.offcn.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.offcn.springboot.entity.Teacher;
import com.offcn.springboot.handler.MyException;
import com.offcn.springboot.result.Result;
import com.offcn.springboot.result.TeacherPage;
import com.offcn.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {
    @GetMapping("/get")
    public String getTeach(){
        return "get方法被访问了";
    }

    @Autowired
    private TeacherService teacherService;

    @PostMapping("insert")
    public Result insertTearcher(@RequestBody Teacher teacher){
        boolean flag = teacherService.save(teacher);
        if (flag){
            return  Result.ok();
        }else {
            return Result.error();
        }

    }

    @GetMapping("/findAll")
    public Result selectTearcher(){
        try {
            List<Teacher> list = teacherService.list();
            Map<String,List<Teacher>> data = new HashMap<>();
            data.put("list",list);
            return Result.ok().data("data",data);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    //修改
    @PutMapping("/update/{id}")
    public Result updateTeacher(@PathVariable String id,@RequestBody Teacher teacher){
        teacher.setId(id);
        System.out.println(id);
        boolean update = teacherService.updateById(teacher);
        if (update){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    //分页查询
    @GetMapping("{page}/{limit}")
    public Result pageList(@PathVariable Long page,@PathVariable Long limit){
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.page(pageParam);
        //查询某一页的数据
        List<Teacher> list = pageParam.getRecords();
        //查询总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("list",list);

    }

    //分页条件查询
    @PostMapping("{page}/{limit}")
    public Result findByPage(@PathVariable Long page, @PathVariable Long limit
                            ,@RequestBody TeacherPage tPage) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam,tPage);
        //查询某一页的数据
        List<Teacher> list = pageParam.getRecords();
        //int i = 1/0;
        //查询总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total", total).data("list", list);

    }
    @RequestMapping("/exception")
    public Result myException(){
        throw new MyException(2002,"自定义异常");
    }
}
