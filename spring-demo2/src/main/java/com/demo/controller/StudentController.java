package com.demo.controller;

import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-21
 * Time: 17:29
 */
@Controller
public class StudentController {

    //使用属性注入的方式获取Bean
    @Autowired
    private StudentService studentService;

    public void sayHi(){
        //调用service 方法
        studentService.sayHi();
    }

}
