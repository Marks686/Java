package com.example.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-24
 * Time: 15:14
 */
@Controller
@ResponseBody
public class CalcController {
    @RequestMapping("/calc")
    public String calc(Integer num1, Integer num2){
        if(num1 == null || num2 == null) return "参数错误";
        return "结果 = " + (num1 + num2);
    }
}
