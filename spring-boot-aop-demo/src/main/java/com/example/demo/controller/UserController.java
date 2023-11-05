package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-05
 * Time: 17:22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/hi")
    public String sayHi(String name){
        System.out.println("执行了 sayHi 方法");
        return "Hi, " + name;
    }

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("执行了 sayHello 方法");
        return "Hello, world.";
    }
}
