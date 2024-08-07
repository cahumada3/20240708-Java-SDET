package com.skillstorm.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.selenium.LoginPage;
import com.skillstorm.selenium.MainPage;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before("@login")
    public void before() {
        //System.setProperty("webdriver.chrome.driver", "C:\\skillstorm\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
    }

    @After("@login")
    public void after() {
        if(driver != null) {
            this.driver.quit();
        }
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        this.loginPage.get();
    }

    @When("I enter valid {string} and {string}") 
    public void iEnterValidCredentials(String username, String password) {
        this.loginPage.setUsername(username);
        this.loginPage.setPassword(password);
    }

    @When("I enter invalid {string} and {string}") 
    public void iEnterInvalidCredentials(String username, String password) {
        this.loginPage.setUsername("incorrect");
        this.loginPage.setPassword("invalid");
    }

    @And("I click the login button") 
    public void iClickTheLoginButton() {
        this.loginPage.clickLogin();
    }

    @Then("I should be redirected to the main page")
    public void iShouldBeRedirectedToTheMainPage() {
        assertTrue(this.mainPage.onPage());
    }

    @Then("I should see a sign off link")
    public void iShouldSeeASignOffLink() {
        assertTrue(this.mainPage.signOffLinkDisplayed());
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String message) {
        assertTrue(this.loginPage.errorMessageDisplayed(message));
    }

}
