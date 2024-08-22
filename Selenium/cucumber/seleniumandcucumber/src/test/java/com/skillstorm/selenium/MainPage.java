package com.skillstorm.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    private static final String baseUrl = "http://testfire.net/main.jsp";

    @FindBy(id = "LoginLink")
    private WebElement signOffLink;

    /**
     * Initializes the driver and sets an implicit wait
     */
    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public boolean onPage() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl().equals(baseUrl);
    }

    public boolean signOffLinkDisplayed() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return signOffLink.isDisplayed();
    }
    
}
