package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-24
 * Time: 15:03
 */
@Controller
//@ResponseBody
@RequestMapping("/resp")
public class RespController {
    @RequestMapping("/hi")
    public String sayHi(){
        return "/hello.html";
    }
}
