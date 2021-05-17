package com.offcn.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.offcn.springboot.entity.Teacher;
import com.offcn.springboot.result.TeacherPage;
import org.springframework.stereotype.Service;


public interface TeacherService extends IService<Teacher> {


    void pageQuery(Page<Teacher> pageParam, TeacherPage tPage);
}
