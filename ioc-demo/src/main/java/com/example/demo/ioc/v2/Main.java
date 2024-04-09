package com.example.demo.ioc.v2;



public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(19,"black");
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car1 = new Car(framework);
        car1.run();
    }
}
