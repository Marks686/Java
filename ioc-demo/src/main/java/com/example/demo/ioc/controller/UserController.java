package com.example.demo.ioc.controller;

import com.example.demo.ioc.config.UserInfo;
import com.example.demo.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    //属性注入
    @Autowired
    private UserService userService;


    @Qualifier("userInfo2")
    @Autowired
    private UserInfo userInfo;

    //使用@Resource指定bean
//    @Resource(name = "userInfo1")
//    private UserInfo userInfo;

    public UserController(){

    }

    //构造方法注入
//    private UserService userService;
//    private UserInfo userInfo;


//    public UserController(UserService userService, UserInfo userInfo) {
//        this.userService = userService;
//        this.userInfo = userInfo;
//    }
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


//    // Setter 方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    public void doController(){
        userService.doService();
        System.out.println(userInfo);
        System.out.println("do Controller...");
    }
}
