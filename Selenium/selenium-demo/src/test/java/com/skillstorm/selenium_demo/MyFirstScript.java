package com.skillstorm.selenium_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFirstScript {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        // navigates you to the webpage
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println(title);
        System.out.println(currentUrl);

        /**
         * need to make sure that the element is on the page in an interactable state 
         * before you can locate it and interact with and interact
         * 
         * implicitlyWait is NOT the best solution most of the time - easy to demonstrate here
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        

        /**
         * WebElement
         *      an interface in the Selenium WebDriver API that represents an HTML element on a webpage
         * 
         *      findByElement() - provides your WebDriver a way to find a single web element on the current page
         *      By - a class in your WebDriver that provides a mechanism to locating elements
         *      By.[locator]("my-text") - finds elements with the same name attribute 
         * 
         * 
         * 
         * Locators
         *      a way to identify elements on a page, 8 different locators:
         * 
         *          className - compound class names are not permitted
         *          cssSelector
         *          id
         *          name
         *          linkText
         *          partialLinkText
         *          tagName
         *          xpath - locate elements matching an xpath expression
         * 
         * 
         * Interacting with Elements
         *      5 basic commands you can execute on an element:
         *  
         *          sendKeys - only applies to text fields and content editable elements
         *          click - applied to any element
         *          clear - only applies to text fields and content editable elements
         *          submit - only applies to form elements
         *          select - only applies to select elements
         */

         WebElement textbox = driver.findElement(By.name("my-text"));
        // WebElement checkBox = driver.findElement(By.id("my-check-2"));
         WebElement submitBtn = driver.findElement(By.cssSelector("button"));
        // WebElement submitBtn2 = driver.findElement(By.tagName("a"));
        // WebElement checkRadio = driver.findElement(By.xpath("//input[@name='my-radio']"));

         textbox.sendKeys("This is my input!");
        // textbox.clear();
        // checkBox.click();
        submitBtn.click();
        // //submitBtn2.click();
        // checkRadio.click();

        // WebElement selectElement = driver.findElement(By.name("my-select"));
        // Select select = new Select(selectElement);
        // //select.selectByVisibleText("Three");
        // select.selectByValue("3");

        // System.out.println(textbox);

        // //quits the web app
        driver.quit();
    }
    
}
