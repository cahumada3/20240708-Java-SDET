package com.skillstorm.hello_spring_boot.beans;

public class ElectricEngine implements Engine {
    @Override
    public void run() {
        System.out.println("WOOOOOOSH");
    }
}
