package com.skillstorm.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private static final String baseUrl = "http://testfire.net/login.jsp";

    /**
     * @FindBy - used to locate web elements on a webpage using locators
     */
    @FindBy(id = "uid")
    private WebElement usernameField;

    @FindBy(id = "passw")
    private WebElement passwordField;

    @FindBy(name = "btnSubmit")
    private WebElement loginButton;

    /**
     * Initializes the driver and sets an implicit wait
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    /**
     * navigating to the login page
     * pause execution for 1000 mili sec before navigation
     */
    public void get() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.get(baseUrl);
    }

    /**
     * entering the username into the username field
     */
    public void setUsername(String username) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        usernameField.sendKeys(username);
    }

    /**
     * entering the password into the password field
     */
    public void setPassword(String password) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        passwordField.sendKeys(password);
    }

    /**
     * clicks the login in button and submits a form
     */
    public void clickLogin() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.submit();
    }
    
}
