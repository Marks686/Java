package com.demo;

import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-13
 * Time: 22:36
 */
public class User {
    public User(){
        System.out.println("执行了User构造方法");
    }
    public String sayHi(){
        return "hello, world.";
    }
}
