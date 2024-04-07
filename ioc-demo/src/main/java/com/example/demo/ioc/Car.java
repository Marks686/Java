package com.example.demo.ioc;

public class Car {
    private Framework framework;

    public Car(int size) {
        framework = new Framework(size);
        System.out.println("car init...");
    }

    public void run() {
        System.out.println("car run...");
    }
}
