package com.example.demo;

import com.example.demo.ioc.controller.UserController;
import com.example.demo.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class  DemoApplication {
    public static void main(String[] args) {
        //Spring 上下文
       ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
       // 从context中获取bean
//       UserController bean = context.getBean(UserController.class);
//       bean.doController();


        UserService userService = context.getBean(UserService.class);
        userService.doService();



        //根据名称获取bean
        UserService userService2 = (UserService) context.getBean("userService");
        userService2.doService();


        //根据名称和类型获取bean
        UserService userService3 = context.getBean("userService",UserService.class);
        userService3.doService();
    }
}
