package com.offcn.springboot.result;

import io.swagger.models.auth.In;
import lombok.Data;

//封装讲师的查询条件
@Data
public class TeacherPage {

    private String name;

    private Integer level;

    private String begin;

    private String end;
}
