package com.example.demo.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.pkcs11.P11Util;


@Controller
@ResponseBody
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "测试Controller和其他注解的区别";
    }
}
