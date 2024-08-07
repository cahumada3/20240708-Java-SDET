package com.skillstorm;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * phrases are CASE SENSITIVE make sure you write the phrase exactly as it is in the feature file
 */
class IsItFriday {
    static String isItFriday(String today) {
        /**
         * checks to see if today is equal to friday
         * if true, return YES
         * if false, return Nope
         */
        return "Friday".equals(today) ? "YES" : "Nope";
    }
}

public class StepDefinitions {
    private String today;
    private String actualAnswer;

    /**
     * @Given maps to the step in the feature file that describes the precondition
     * Makes "today is Sunday" into a concrete condition
     */
    @Given("today is Sunday")
    public void todayIsSunday() {
        today = "Sunday";
    }

    /**
     * Makes "today is Friday" into a concrete conditon
     */
    @Given("today is Friday")
    public void todayIsFriday() {
        today = "Friday";
    }

    /**
     * @When maps to the step in the feature file that describes the action or event
     */
    @When("I ask whether it's Friday yet")
    public void iAskWhetherItsFridayYet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    /**
     * @Then maps to the step in the feature file the expected outcome
     * Will take in a parameter of type string to compare whether the 
     * expectedAnswer and actualAnswer match using assertEquals()
     */
    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
