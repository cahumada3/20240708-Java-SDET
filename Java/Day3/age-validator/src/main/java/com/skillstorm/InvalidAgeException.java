package com.skillstorm;

/**
 * Creating custom exceptions
 *      - needs to extend an existing exception class
 *      - should have 'Exception' at the end of its name
 * 
 * why should you create your own custom exceptions?
 *      - allows for extra readability
 */

public class InvalidAgeException extends IllegalArgumentException {

    public InvalidAgeException() { }

    public InvalidAgeException(String message) {
        super(message);
    }
    
}
