package com.example.demo.ioc.v1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(17);
        car1.run();
        Car car2 = new Car(19);
        car2.run();
    }
}
