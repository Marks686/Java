package com.example.demo.controller;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-08
 * Time: 21:43
 */
@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping
//    public String getMethod(){
//        return "执行 GET 请求方式";
//    }
//
//    @PostMapping
//    public String postMethod(){
//        return "执行 POST 请求方式";
//    }
    @RequestMapping("/getnum")
    public Integer getNumber(){
        return new Random().nextInt(10);
    }

    @RequestMapping("/getuser")
    public String getUser(){
        System.out.println("执行了 getUer");
        return "get user";
    }

    @RequestMapping("/login")
    public String login(){
        Object obj = null;
        obj.hashCode();
        System.out.println("执行了 login");
        return "login";
    }
    @RequestMapping("/reg")
    public String reg(){
        int num = 10/0;
        System.out.println("执行了 reg");
        return "reg";
    }
}
