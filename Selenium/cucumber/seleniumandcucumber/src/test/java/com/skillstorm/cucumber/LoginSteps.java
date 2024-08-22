package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.selenium.LoginPage;
import com.skillstorm.selenium.MainPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before("@login")
    public void before() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
    }

    @Given("I am on the login page ")
    public void i_am_on_the_login_page() {
        this.loginPage.get();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_credentials(String username, String password) {
        this.loginPage.setUsername(username);
        this.loginPage.setPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        this.loginPage.clickLogin();
    }

    @Then("I should be redirected to the main page")
    public void i_should_be_redirected_to_main_page() {
        assertTrue(this.mainPage.onPage());
    }

    @And("I should see a sign off link")
    public void i_should_see_a_sign_off_link() {
        assertTrue(this.mainPage.signOffLinkDisplayed());
    }

}
