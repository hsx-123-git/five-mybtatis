package com.offcn.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offcn.springboot.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository                          /*必须加泛型 要不然不知道操作数据库中的那个表*/
public interface TeacherMapper extends BaseMapper<Teacher> {

}
