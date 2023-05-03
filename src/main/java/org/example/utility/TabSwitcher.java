package org.example.utility;

import org.example.Browser;
import org.openqa.selenium.WebDriver;

public class TabSwitcher {

    public static void switchToPage() {
        WebDriver driver = Browser.getDriver();
        String currentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
