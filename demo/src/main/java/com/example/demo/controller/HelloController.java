package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-24
 * Time: 16:52
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping(value = "/sayhi",method = RequestMethod.GET)
    public String sayHi(){
        return "hi,SpringBoot!!!";
    }
    @RequestMapping("/sayhello")
    public String sayHello(){
        return "hello,SpringBoot!!!";
    }
    @RequestMapping("/sayno")
    public String sayno(){
        return "no!!!";
    }
}
