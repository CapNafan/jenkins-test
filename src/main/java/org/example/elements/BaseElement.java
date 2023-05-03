package org.example.elements;

import org.example.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    public final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public void click() {
        getElement().click();
    }

    public String getText() {
        return getElement().getText();
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    public WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }
}