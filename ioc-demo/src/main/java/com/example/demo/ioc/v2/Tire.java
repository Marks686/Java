package com.example.demo.ioc.v2;

public class Tire {
    private int size;
    private String color;

    public Tire(int size,String color) {
        this.size = size;
        this.color = color;
        System.out.println("tire init...size：" + size + " color:" + color);
    }
}
