package com.offcn.springboot;

import com.offcn.springboot.entity.Teacher;
import com.offcn.springboot.mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.offcn.springboot.mapper")
class SpringbootMybatisplusApplicationTests {


    @Autowired
    private TeacherMapper teacherMapper;


    @Test
    public void tes() {
        Teacher teacher = new Teacher();
//        teacher.setId("2");
        teacher.setName("啧啧啧");
        teacher.setIntro("高级讲师");
        teacherMapper.insert(teacher);
        System.out.println(teacher);

    }
    @Test
    public void test1(){
        Teacher teacher = teacherMapper.selectById(1);
        System.out.println(teacher);
    }

    @Test
    public void updateTeacher1() {
        Teacher teacher = teacherMapper.selectById("2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        teacher.setName("你好");
        teacherMapper.updateById(teacher);
    }


}
