package com.example.demo.facade;

public class FacadePattern {
    public void lightOn(){
        HallLight hallLight = new HallLight();
        hallLight.on();
        LivingLight livingLight = new LivingLight();
        livingLight.on();
        DiningLight diningLight = new DiningLight();
        diningLight.on();
    }
}
