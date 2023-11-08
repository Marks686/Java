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

    @GetMapping
    public String getMethod(){
        return "执行 GET 请求方式";
    }

    @PostMapping
    public String postMethod(){
        return "执行 POST 请求方式";
    }
}
