package com.skillstorm.selenium_demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * TestNG - (Next Generation)
 *      a testing framework widely used with Selenium for automation tetsing (takes from JUnit and NUnit)
 *          - overcomes some the disadvantages of JUnit and makes E2E testing easier
 *          - allows you to run only failed test cases
 *          - uses annotations to define test methods and configurations
 *          - you can parallel testing
 *          - test cases can be grouped
 *          - create reports
 * 
 *          @Test - used to let us known that the method under is a test case
 *          @BeforeSuite - runs before all test cases in this suite have run
 *          @AfterSuite - runs after all test cases in this suite have run
 *          @BeforeTest - runs before the execution of all test methods annotated with @Test
 *          @AfterTest - runs after the execution of all test methods annotated with @Test
 *          @BeforeClass - runs before the first test method in the current class that has been run 
 *          @AfterClass - runs after all test methods in the current class have been run
 *          @BeforeMethod - runs before each test method within a test class
 *          @AfterMethod - runs after each test method within a test class 
 *          @BeforeGroups - runs before any test method belonging to the specified groups is executed
 *          @AfterGroups - runs after any test method belonging to the specified groups is executed
 * 
 *      BeforeSuite, BeforeTest, BeforeClass, BeforeMethod will always run regardless of what group it belongs to 
 *          
 */

public class TestNG {
    @Test
    public void test1() {
        System.out.println("My first test case");
    }

    @Test
    public void test2() {
        System.out.println("My second test case");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This will execute Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This will execute After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This will execute Before Class execution");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This will execute After Class execution");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This will execute Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This will execute After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute After Suite");
    }
    
    @Test
    public void test3() {
        System.out.println("My third test case");
    }

    @BeforeGroups
    public void beforeGroup() {
        System.out.println("This well execute Before Groups");
    }
}
