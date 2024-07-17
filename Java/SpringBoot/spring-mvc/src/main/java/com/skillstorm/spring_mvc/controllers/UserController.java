package com.skillstorm.spring_mvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Controller vs RestController
 * 
 *      @RestController implicity adds @ResponseBody to every method in the class
 *      @Controller - you have to include it on every method 
 *      @ResponseBody will tell the controller that the object returned is serialized into JSON insode 
 *                    the body of the HTTP response
 *      @RequestMapping will allow us to map all of our requests to a specific path
 * 
 */

// localhost:8080/users/helloWorld

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }
    
}
