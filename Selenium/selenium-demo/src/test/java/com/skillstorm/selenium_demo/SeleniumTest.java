package com.skillstorm.selenium_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    WebDriver driver;
    String baseUrl = "http://testfire.net";

    @Test(priority = 0)
    public void verifyTitle() {
        System.out.println("Test 1: Verifying the title");
        String expectedTitle = "Altoro Mutual";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 1)
    public void navigateToLogin() {
        System.out.println("Test 2: Navigates to login page");
        driver.navigate().to("http://testfire.net/login.jsp");
        WebElement loginHeader = driver.findElement(By.tagName("h1"));
        String loginHeaderText = loginHeader.getText();
        assertEquals("Online Banking Login", loginHeaderText);
    }

    @Test(priority = 2)
    public void login() {
        System.out.println("Test 3: Login user");
        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginButton = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("admin");
        password.sendKeys("admin");
        loginButton.submit();
    }


    @BeforeTest
    public void launchBrowser() {
        System.out.println("BeforeTest: Launching Chrome Browser");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: This will execute Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: Start Testing on Browser");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: This will execute After Class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: Finished Testing on Browser");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: All tests have finished");
        driver.quit();
    }
    
}
