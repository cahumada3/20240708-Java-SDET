package com.skillstorm.hello_spring_boot.beans;

public class Car implements Vehicle {

    private Engine engine;

    public Car() {
        System.out.println("*** Constructor: Car() ***");
    }

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("*** Constructor: Car(Engine engine) ***");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void drive() {
        this.engine.run();
    }


    
    
}
