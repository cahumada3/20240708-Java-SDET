package com.skillstorm.demo.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;                // Simple logging facade for java - abstraction for logging frameworks
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.skillstorm.demo.models.Director;


@Component         // TODO tell Spring that this is a bean
@Aspect            // TODO tells AspectJ that this is an aspect 
public class LoggingAspect {

    /*
     * Spring Boot provides logging configuration OTB (out of the box)
     * 
     *  Logging Levels:
     *      fatal -> error -> warn -> info -> debug -> trace
     *      set this in application.properties (or application.yml) using
     * 
     *   logging.level.com.skillstorm.demo=debug
     */

     // TODO Create Logger using LoggerFactory
     Logger logger = LoggerFactory.getLogger(getClass());
    

    /*
     * ASPECTS 
     *      Join Points -  
     * 
     *      Point Cut - 
     * 
     *      Advice - 
     */

    /*
     * options for defining point cut:
     *      within() - specify a package or class
     *      execution() - when a specific method executes
     *      bean() - for a specific bean
     */
    // TODO
    @Pointcut("")   // any method in the MovieController class is now a pointcut
    public void checkMovie() {
        /* leave empty - the code inside wont ever run */
    }

    /* 
     TODO Define another pointcut using AspectJ expression notation


     */

    /*
    * Types of Advice
    *      Before - 
    *      After - 
    *      AfterReturning - 
    *      AfterThrowing - 
    *      Around - 
    */

    // Before
    public void request() {

    }

    // AfterReturning
    public void response() {
        
    }

    // AfterThrowing we are using the RestControllerAdvice to handle
    // see file com.skillstorm.controllers.GlobalExceptionHandler.java

    // Around
    public Director preventPostDoingUpdate() { // 
        /*
         * PROCEEDING JOIN POINT
         *      join point that has an extra method: .proceed()
         * 
         *      aspect is going to interrupt a method and do something - then that method gets executed
         *      with a proceeding join point, it WILL NOT execute that method, until you call .proceed()
         * 
         */
        return null;
    }
    
}