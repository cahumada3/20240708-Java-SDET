package com.skillstorm.hello_spring_boot.beans;

public class GasEngine implements Engine {
    
    @Override
    public void run() {
        System.out.println("VROOOOOOOOM!!!");
    }
}
