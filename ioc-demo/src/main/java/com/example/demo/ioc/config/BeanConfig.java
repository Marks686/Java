package com.example.demo.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {
    @Bean
    public String name(){
        return "zhangsan";
    }
//    @Bean
//    public String name2(){
//        return "wangwu";
//    }

    @Primary
    @Bean
    public UserInfo userInfo1(String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName(name);
        userInfo.setAge(18);
        return userInfo;
    }
    @Bean
    public UserInfo userInfo2(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setName("lisi");
        userInfo.setAge(19);
        return userInfo;
    }
}
