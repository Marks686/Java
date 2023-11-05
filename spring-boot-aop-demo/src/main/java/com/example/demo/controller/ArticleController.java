package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-05
 * Time: 17:29
 */
@RestController
@RequestMapping("/art")
public class ArticleController {
    @RequestMapping("/hi")
    public String sayHi(){
        return "Hi, world.";
    }
}
