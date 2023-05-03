package org.example;

import org.example.utility.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String startUrl = BrowserConfig.getStartUrl();
        driver = Browser.getDriver();
        driver.navigate().to(startUrl);
    }

    @AfterMethod
    public void tearDown() {
        Browser.quitDriver();
    }
}
