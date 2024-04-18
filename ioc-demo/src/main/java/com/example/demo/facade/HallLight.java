package com.example.demo.facade;

public class HallLight implements Light{

    @Override
    public void on() {
        System.out.println("打开走廊的灯");
    }

    @Override
    public void off() {
        System.out.println("关闭走廊得灯");
    }
}
