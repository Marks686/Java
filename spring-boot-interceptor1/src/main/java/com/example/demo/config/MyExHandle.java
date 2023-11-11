package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-09
 * Time: 20:30
 */
@ControllerAdvice
@ResponseBody
public class MyExHandle {
    // 拦截所有的空指针异常 进行统一得数据返回
    @ExceptionHandler(NullPointerException.class)
    public HashMap<String,Object> nullException(NullPointerException e){
        HashMap<String,Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg","空指针异常: " + e.getMessage()); //错误码的描述信息
        result.put("data",null);
        return result;
    }
    @ExceptionHandler(Exception.class)
    public HashMap<String,Object> exception(Exception e){
        HashMap<String,Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg","异常: " + e.getMessage()); //错误码的描述信息
        result.put("data",null);
        return result;
    }
}
