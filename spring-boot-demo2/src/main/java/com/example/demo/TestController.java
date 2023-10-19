package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-14
 * Time: 16:08
 */
@Controller   // 当前类为控制器
@ResponseBody // 返回的是数据 而非页面
//@PropertySource(value = "classpath:application.properties",encoding = "utf-8")
public class TestController {

    // 读配置文件中的mytest
    @Value("${mytest}")
    private String mytest;


    @Value("${mytest2}")
    private String mystest2;

    @Value("${myString}")
    private String myString;

    @Value("${myString2}")
    private String myString2;


    @Value("${myString3}")
    private String myString3;



    @PostConstruct
    public void postConstruct(){
        System.out.println("myString:" + myString);
        System.out.println("myString2:" + myString2);
        System.out.println("myString3:" + myString3);

    }

    @RequestMapping("/hi") // url路由注册
    public String sayHi(String name){
        // 为空或为null 默认值处理
//        if (name == null || name.equals("")){
//            name = "张三";
//        }
        if (!StringUtils.hasLength(name)){
            name = "张三";
        }
        return "你好: " + name;
    }

    @RequestMapping("/getconf")
    public String getConfig(){
        return "mytest = " + mytest
                + " mytest2 = " + mystest2;
    }
}
