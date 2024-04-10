package com.example.demo.ioc.controller;

import com.example.demo.ioc.component.UserComponent;
import com.example.demo.ioc.config.UserConfig;
import com.example.demo.ioc.config.UserInfo;
import com.example.demo.ioc.repo.UserRepository;
import com.example.demo.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.demo")
@SpringBootApplication
public class  DemoApplication {
    public static void main(String[] args) {
        //Spring 上下文
       ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
       // 从context中获取bean
       UserController bean = context.getBean(UserController.class);
       bean.doController();

//        UserService userService = context.getBean(UserService.class);
//        userService.doService();
//
//        //根据名称获取bean
//        UserService userService2 = (UserService) context.getBean("userService");
//        userService2.doService();
//
//
//        //根据名称和类型获取bean
//        UserService userService3 = context.getBean("userService",UserService.class);
//        userService3.doService();
//
//        //读取Repository bean 的代码：
//        UserRepository userRepository = context.getBean(UserRepository.class);
//        userRepository.doRepository();
//
//        UserComponent userComponent = context.getBean(UserComponent.class);
//        userComponent.doComponent();
//
//        UserConfig userConfig = context.getBean(UserConfig.class);
//        userConfig.doConfiguration();
//        System.out.println("userConfiguration :" + userConfig);
//
//        UserConfig userConfig2 = context.getBean(UserConfig.class);
//        userConfig2.doConfiguration();
//        System.out.println("userConfigurationw2 :" + userConfig2);
//        System.out.println("======================");
//        System.out.println("userConfiguration == userConfigurationw2" + (userConfig == userConfig2));
//
//        //使用@Bean
//        UserInfo userInfo = (UserInfo) context.getBean("userInfo");
//        System.out.println(userInfo);
//        UserInfo userInfo2 = context.getBean("userInfo",UserInfo.class);
//        System.out.println(userInfo2);
    }
}
