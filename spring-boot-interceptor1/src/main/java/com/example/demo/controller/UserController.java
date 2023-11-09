package com.example.demo.controller;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/getuser")
    public String getUser(){
        System.out.println("执行了 getUer");
        return "get user";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("执行了 login");
        return "login";
    }
    @RequestMapping("/reg")
    public String reg(){
        System.out.println("执行了 reg");
        return "reg";
    }
}
