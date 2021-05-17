package com.offcn.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Teacher {
    //MyBatis-Plus默认的主键策略是：ID_WORKER  **全局唯一ID**
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private String intro;
    private String career;
    private Integer level;
    private Integer sort;
    //添加注解就可以利用mp的自动填充功能，不需要每次都填充了
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //定义版本号字段
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;

}
