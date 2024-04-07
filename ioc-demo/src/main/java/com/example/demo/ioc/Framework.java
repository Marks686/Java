package com.example.demo.ioc;

public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
