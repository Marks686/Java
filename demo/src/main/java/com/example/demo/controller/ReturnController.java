package com.example.demo.controller;

import com.example.demo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-04-02
 * Time: 10:58
 */
@RequestMapping("/return")
//@RestController
@Controller
public class ReturnController {
    @RequestMapping("/index")
    public  String returnIndex(){
        return "/index.html";
    }


    @ResponseBody
    @RequestMapping("/returnData")
    public  String returnData(){
        return "返回视图需要的数据";
    }


    @ResponseBody
    @RequestMapping("/returnHtml")
    public  String returnHtml(){
        return "<h1>返回HTML代码片段</h1>";
    }


    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson(){
        Person person = new Person();
        person.setId(1);
        person.setName("zhangsan");
        person.setAge(7);
        return person;
    }

    @ResponseBody
    @RequestMapping("/returnMap")
    public Map<String, String> returnMap(){
        Map<String,String> kv = new HashMap<>();
        kv.put("k1","v1");
        kv.put("k2","v2");
        kv.put("k3","v3");
        return kv;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response){
        response.setStatus(401);//通常表示没有登录
        return "设置状态码成功";
    }

    @ResponseBody
    @RequestMapping(value = "/r1",produces = "application/json;charset=utf-8")
    public String r1(HttpServletResponse response){
        return "{'oK':1}";
    }
}
