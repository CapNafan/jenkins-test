package org.example.utility;

import org.example.Browser;
import org.example.elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitUntil {

    private static final Integer WAIT_SEC = BrowserConfig.getExplicitWaitInSeconds();

    private static void waitUntil(ExpectedCondition<?> condition) {
        WebDriver driver = Browser.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SEC));
        wait.until(condition);
    }

    public static void waitForPresence(BaseElement element) {
        waitUntil(ExpectedConditions.presenceOfElementLocated(element.locator));
    }

    public static void waitToBeClickable(BaseElement element) {
        waitUntil(ExpectedConditions.elementToBeClickable(element.locator));
    }
}
