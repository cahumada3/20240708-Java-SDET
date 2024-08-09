package com.skillstorm.selenium_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.get("http://testfire.net");
        String title = driver.getTitle();
        assertEquals("Altoro Mutual", title);
        
        driver.navigate().to("http://testfire.net/login.jsp");
        assertEquals("Altoro Mutual", title);

        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginBtn = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("jsmith");
        password.sendKeys("Demo1234");
        loginBtn.submit();

        WebElement message = driver.findElement(By.tagName("h1"));
        String value = message.getText();
        assertEquals("Hello John Smith", value);    // will throw an error if expected and actual value do not equal

    }

    @Test
    public void navigation() {
        driver.get("http://testfire.net");

        driver.navigate().to("http://testfire.net/login.jsp");

        driver.navigate().to("http://testfire.net/index.jsp?content=personal.htm");

        driver.navigate().back();

        driver.navigate().forward();
    }

    @AfterEach
    public void teardown() {
        /**
         * Ways to teardown browser:
         *      quit() - used to close all the browser windows and terminate driver
         *      close() - used to close current window 
         */
        //driver.quit();
    }
}
