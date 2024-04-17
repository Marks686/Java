package com.example.demo.ioc.controller;

import com.example.demo.model.DBType;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class YmlController {
    @Value("${demo.key1}")
    public String key1;
    @RequestMapping("/readYml")
    public String readYml(){
        return key1;
    }

    @PostConstruct
    public void init(){
//        System.out.println("key1:" + key1);
        System.out.println("student: " + student);
        System.out.println("dbtype:" + dbType);
    }


    @Autowired
    public Student student;

    @Autowired
    public DBType dbType;
}
