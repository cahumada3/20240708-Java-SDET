package com.skillstorm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

/**
 * JUNIT - unit testing framework
 *       - unit testing is testing the individual components to ensure they work as intended
 * 
 * JUNIT ANNOTATIONS
 *      BeforeClass
 *      Before
 *      Test
 *      Ignore
 *      After
 *      AfterClass
 * 
 *      if you have multiple methods of the same annotation type, 
 *      JUNIT does not guarentee the order that the matching annotations will run
 * 
 */

public class AgeValidatorTest 
{
    static AgeValidator ageValidator;

    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;

    /**
     * BeforeClass and Before
     *      - these are setup methods
     *          used to initialize data you will use within your tests
     * 
     *      BeforeClass - run once before all of the other methods
     *          ex: to setup a datbase connection
     * 
     *      Before - will run right before each test
     *          ex: load data from the database  
     */

    @BeforeClass
    public static void setupAgeValidator() {
        ageValidator = new AgeValidator();
    }

    @Before
    public void setupPeople() {
        person1 = new Person("Marvin", 13);
        person2 = new Person("Kalabe", 16);
        person3 = new Person("Arthur", 17);
        person4 = new Person("Britt", 19);
        person5 = new Person("Kirk", 21);
    }

    /**
     * tests either pass or fail
     *      tests only fail if an exception is thrown and is unhandled
     * 
     * junit has assertion methods to throw exceptions for you - they don't return anything
     */

    @Test
    public void testOldEnoughToDrive() {
        try {
            assertFalse(ageValidator.oldEnoughToDrive(person1));
            assertFalse(ageValidator.oldEnoughToDrive(person2));
            assertEquals(ageValidator.oldEnoughToDrive(person3), ageValidator.oldEnoughToDrive(person4));
            assertTrue(ageValidator.oldEnoughToDrive(person5));

        } catch (InvalidAgeException e) {
            System.out.println("Not old enough!");
            //throw new InvalidAgeException("Must be at least 21 years old to buy alcohol!");
            //throw new InvalidAgeException(e.getMessage());
        }
    }

    @Test(expected = InvalidAgeException.class)
    public void testOldEnoughToVote() {
            assertFalse(ageValidator.oldEnoughToVote(person1));
            assertFalse(ageValidator.oldEnoughToVote(person2));
            assertEquals(ageValidator.oldEnoughToVote(person3), ageValidator.oldEnoughToVote(person4));
            assertTrue(ageValidator.oldEnoughToVote(person5));
    }

    @Test
    public void testOldEnoughToPurchaseAlcohol() {
        assertThrows(InvalidAgeException.class, new ThrowingRunnable() {

            @Override
            public void run() {
                ageValidator.oldEnoughToPurchaseAlcohol(person1);
            }
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person2);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person3);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToPurchaseAlcohol(person4);
        });

        assertTrue(ageValidator.oldEnoughToVote(person5));
    }
    
    /**
     * After and AfterClass
     *      these are teardown methods taht are used to delete/rollback things that were setup
     * 
     *      After - run after each test has finished
     *      AfterClass - will run once at the end of all test being finsihed
     */


    @After
    public void teardownPeople() {
        person1 = null;
        person2 = null;
        person3 = null;
        person4 = null;
        person5 = null;

    }

    @AfterClass
    public static void teardownAgeValidator() {
        ageValidator = null;
    }

}
