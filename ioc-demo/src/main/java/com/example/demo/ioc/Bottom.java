package com.example.demo.ioc;

public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size);
        System.out.println("bottom init...");
    }
}
