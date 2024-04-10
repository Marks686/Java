package com.example.demo.ioc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    public void doConfiguration(){
        System.out.println("do Configuration...");
    }
}
