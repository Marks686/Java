package com.example.demo.ioc;

public class Tire {
    private int size;

    public Tire(int size) {
        this.size = size;
        System.out.println("tire init...size：" + size);
    }
}
