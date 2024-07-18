package com.skillstorm.hello_spring_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.skillstorm.hello_spring_boot.beans.Car;
import com.skillstorm.hello_spring_boot.beans.ElectricEngine;
import com.skillstorm.hello_spring_boot.beans.Engine;
import com.skillstorm.hello_spring_boot.beans.GasEngine;
import com.skillstorm.hello_spring_boot.beans.Vehicle;

@Configuration
public class CarConfiguration {

    /**
     * where we can configure our car beans
     * 
     *      telling spring boot wher to get out beans from/how to initialize them
     * 
     * 
     * @BEAN
     *      - register the bean inside the BeanFactory
     *      - this way spring can give you beans when you ask from them
     * 
     * 
     * @SCOPE - tells spring what kind of bean you want
     *      BEAN SCOPES:
     *          singleton - each bean will be the same (this is the default, if you dont specify a new scope) **
     *          prototype - each bean will be different **
     *          application - creates a bean for the lifespan of the entire app
     *          request - creates a bean for the lifespan of an HTTP request *
     *          session - creates a bean for the lifespan of a user's session *
     *          websocket - creates a bean for the lifespan of a websocket
     *      
     */
    

    /**
     * there are 2 types of dependency injection
     *      - setter injection
     *      - constructor injection
     * 
     */

    @Bean(name = {"mustang", "camaro"})
    @Scope("prototype")
    public Vehicle gasCar() {
        Car car = new Car();
        car.setEngine(gasEngine());     // setter injection
        return car;
    }

    @Bean(name = "tesla")
    @Scope("singleton")       // default bean scope
    public Vehicle electricCar() {
        Car car = new Car(electricEngine());    // constructor injection
        return car;
    }

    @Bean
    public Engine gasEngine() {
        return new GasEngine();
    }

    @Bean
    public Engine electricEngine() {
        return new ElectricEngine();
    }
}
