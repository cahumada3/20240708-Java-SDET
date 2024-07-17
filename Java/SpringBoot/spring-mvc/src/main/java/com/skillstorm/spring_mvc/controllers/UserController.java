package com.skillstorm.spring_mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_mvc.dtos.UserDto;
import com.skillstorm.spring_mvc.models.User;
import com.skillstorm.spring_mvc.services.UserService;



/**
 * 
 * Controller vs RestController
 * 
 *      @RestController implicity adds @ResponseBody to every method in the class
 *      @Controller - you have to include it on every method 
 *      @ResponseBody will tell the controller that the object returned is serialized into JSON insode 
 *                    the body of the HTTP response
 *      @RequestMapping will allow us to map all of our requests to a specific path
 *                      - is very general and will return any http request
 * 
 */

// localhost:8080/users/helloworld

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired      // will ask spring boot to give us this service
    UserService service;

    /**
     * GET - retrieves data
     * POST - creates data
     * PUT - updates data
     * DELETE - deletes data
     */

    // the actual path for the http request will be /users/helloworld
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

    /**
     * GetMapping is an HTTP GET Request
     *      same as @RequestMapping("path", method=RequestMethod.GET)
     */  

    @GetMapping      // no path specified - means it'll just be /users
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/dtos")      
    public List<UserDto> findAllUsersDto() {
        return service.findAllUsersDto();
    }

    /**
     * @RequestParam
     *      finds the data for the parameter in the url path
     * 
     *      /users/first_name?firstName=[data] - everything after the ? are your parameters
     */

    @GetMapping("/first_name")
    public List<User> findByFirstName(@RequestParam String firstName) {
        return service.findUsersByFirstName(firstName);
    }


    @GetMapping("/user/{id}")
    public User findById(@PathVariable long id) {
        return service.findById(id);
    }

    /**
     * PostMapping - typically for creating data
     * 
     * ResponseEntity - object that gives you more control over your http response
     *                - modify headers, status code, etc.
     * 
     * RequestBody - looks for the data in the body of the request
     *             - deserialize JSON to java object
     */
    @PostMapping("/user") 
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = service.createUser(user);

        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    /**
     * PutMapping - used to update data
     */
    @PutMapping("/user/{id}") 
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }
    
    // @DeleteMapping("/user/{id}")
    // public ResponseEntity<User> deleteUser(@PathVariable long id, @RequestBody User user) {
    //     service.deleteUser(id, user);

    //     return new ResponseEntity<User>(HttpStatus.NO_CONTENT); // sets the status code to 204 - No Content
    // }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        service.deleteUser(id);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT); // sets the status code to 204 - No Content
    }
    
}
