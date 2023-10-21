package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-20
 * Time: 17:32
 */
@RequestMapping("/user")
@Controller
@ResponseBody // 设置当前类中所有的方法返回的是数据而非页面
public class UserController {

    // 1. 得到日志对象
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    // 2. 使用日志对象来打印日志(使用日志对象提供的内置方法来打印)


    @RequestMapping("/hi")
    public String sayHi(){
        //写日志
        logger.trace("我是 trace");
        logger.debug("我是 debug");
        logger.info("我是 info");
        logger.warn("我是 warn");
        logger.error("我是 error");
        System.out.println("我是 System.");
        return "Hi,Spring Boot.";
    }

}
