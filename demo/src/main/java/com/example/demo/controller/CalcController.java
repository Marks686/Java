package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-04-02
 * Time: 20:11
 */
@RequestMapping("/calc")
@RestController
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1,Integer num2){
        Integer sum = num1 + num2;
        return "计算结果为：" + sum;
    }
}
