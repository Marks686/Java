package com.example.demo.ioc.service;


import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void doService(){
        System.out.println("do service...");
    }
}
