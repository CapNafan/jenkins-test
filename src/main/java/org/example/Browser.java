package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utility.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Browser {

    private static WebDriver driver;

    private Browser() {}

    public static WebDriver getDriver() {
        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "src/main/java/org/example/drivers/chromedriver");
            ChromeOptions options = BrowserConfig.getChromeOptions();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}