package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-14
 * Time: 16:08
 */
@Controller   // 当前类为控制器
@ResponseBody // 返回的是数据 而非页面
public class TestController {

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
}
