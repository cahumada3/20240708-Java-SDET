package com.skillstorm.selenium_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestNG {
    WebDriver driver;
    String baseUrl = "http://testfire.net/login.jsp";

    @Test(priority = 2) //prioritize test methods (0 = highest priority)
    public void verifyGreeting() {
        System.out.println("Test 3: Verifying the greeting once a user is logged in");
        String expectedGreeting = "Hello Admin User";
        WebElement message = driver.findElement(By.tagName("h1"));
        String actualGreeting = message.getText();
        Assert.assertEquals(actualGreeting, expectedGreeting);
    }

    @Test(enabled = false) //ignores/skips test method
    public void verifyTitle() {
        System.out.println("Test 2: Verifying the title");
        String expectedTitle = "Altoro Mutual";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 0)
    public void login() {
        System.out.println("Test Case 1: Logging into Altoro Mutual as Admin");
        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginButton = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("admin");
        password.sendKeys("admin");
        loginButton.click();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute Before Suite");
    }

    @BeforeTest
    public void launchChromeBrowser() {
        System.out.println("BeforeTest: Launching Chrome Browser");
        System.out.println("Chrome Thread : " + Thread.currentThread().getId());
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @BeforeTest
    public void launchEdgeBrowser() {
        System.out.println("BeforeTest: Launching Edge Browser");
        //System.out.println("Edge Thread : " + Thread.currentThread().getId());
        //driver = new EdgeDriver();
        //driver.get(baseUrl);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This will execute Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: Start testing on browser");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: Finished testing on browser");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This will execute After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: All tests have finished - termanating browser");
        //driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute After Suite");
    }
}
