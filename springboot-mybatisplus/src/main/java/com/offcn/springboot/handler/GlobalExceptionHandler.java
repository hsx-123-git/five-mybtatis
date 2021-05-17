package com.offcn.springboot.handler;

import com.offcn.springboot.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* @ControllerAdvice主要有三个功能
* 1、全局异常处理
* 2、全局数据绑定
* 3、全局数据预处理
* 可以帮助我们简化很多工作，这个注解是springmvc里的，在springboot中也可以直接使用
* */
@ControllerAdvice
public class GlobalExceptionHandler {
    //当出现异常就会自动调用这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error().message("执行出现异常");
    }

    //特定异常：算数异常 异常精确匹配才会走这个否则就会走父类
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException a){
        //打印异常信息
        a.printStackTrace();
        return Result.error().message("算数异常！！！");
    }

    //自定义异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result error(MyException m){
        m.printStackTrace();
        return Result.error().message("自定义异常！！！");
    }
}
