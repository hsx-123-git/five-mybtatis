package com.offcn.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offcn.springboot.entity.Teacher;
import com.offcn.springboot.mapper.TeacherMapper;
import com.offcn.springboot.result.TeacherPage;
import com.offcn.springboot.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    //分页条件查询
    @Override
    public void pageQuery(Page<Teacher> pageParam, TeacherPage tPage) {
        //条件构造器
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        if (tPage == null){
            baseMapper.selectPage(pageParam,null);
            return;
        }
        //获取值
        String name = tPage.getName();
        Integer level = tPage.getLevel();
        String begin = tPage.getBegin();
        String end = tPage.getEnd();
        //如果name存在就进行模糊查询
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            //查询条件等于level里的值
            wrapper.eq("level",level);
        }

        if (!StringUtils.isEmpty(begin)){
            //创建时间大于等于begin
            wrapper.ge("create_time",begin);
        }
        if (!StringUtils.isEmpty(end)){
            //创建时间小于等于end
            wrapper.le("create_time", end);
        }

        //查询数据
        baseMapper.selectPage(pageParam,wrapper);
    }
}
