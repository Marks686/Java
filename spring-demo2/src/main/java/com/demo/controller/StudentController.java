package com.demo.controller;

import com.demo.component.UserComponent;
import com.demo.model.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-21
 * Time: 17:29
 */
@Controller
public class StudentController {

//    // 1. 使用属性注入的方式获取Bean
//    //@Autowired
//    @Resource
//    private StudentService studentService;

//    // 2. set 注入
//    private StudentService studentService;
//
//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }

//    // 3. 构造方法注入
//    private final StudentService studentService;
//
//    //private UserComponent userComponent;
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

//    public StudentController(StudentService studentService,
//                             UserComponent userComponent) {
//        this.studentService = studentService;
//        this.userComponent = userComponent;
//    }


//    public void sayHi(){
//        //调用service 方法
//        studentService.sayHi();
//    }

    //@Resource(name = "student1")
    @Autowired
    @Qualifier("student2")
    private Student student;

    public void sayHi(){
        System.out.println(student.toString());
    }

}
