package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-21
 * Time: 20:50
 */
@RequestMapping("/test")
//@ResponseBody      // 告诉我要返回的body数据 不是页面
//@Controller        // 让框架启动的时候加载当前类
//@Component     // 张冠李戴 尽量不这样去写
@RestController  // @Controller + @ResponseBody
public class TestController {

//    @RequestMapping("/hi")
//    @RequestMapping(value = "/hi",method = RequestMethod.POST)
//    @PostMapping("/hi") // 当前接口只支持 POST
    @GetMapping("/hi")
    public String sayHi(String name,Integer v){
        return "Hi," + name + " |   V:" + v;
    }

    @GetMapping("/num")
    public String getNum(Integer num){
        return "num= " + num;
    }


    @GetMapping("/show-user")
    public String showUser(User user){
        return user.toString();
    }

    // 接收 JSON 对象 (和第三方系统通讯是常见的场景)
    @PostMapping("show-json-user")
    public String showJSONUser(@RequestBody User user){
        return user.toString();
    }


    @GetMapping("/show-time")
//    public String showTime(String t,String t2){
    public String showTime(@RequestParam(value = "t",required = false) String startTime,
                           @RequestParam("t2") String endTime){
        return "开始时间： " + startTime + "    |  结束时间： " + endTime;
    }
}
