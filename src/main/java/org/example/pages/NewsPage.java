package org.example.pages;

import org.example.Browser;
import org.example.Constants;
import org.example.elements.Label;
import org.example.elements.Link;
import org.example.forms.BaseForm;
import org.example.utility.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPage extends BaseForm {

    public NewsPage() {
        super(new Link(By.xpath("//div[contains(@class,'SidebarContainer')]")));
    }

    private final WebDriver driver = Browser.getDriver();

    public void enableFilterSection() {
        Link filterLink = new Link(By.xpath("//div[contains(@class,'FilterLink')]"));
        filterLink.click();
    }

    public void uncheckActiveCheckboxes() {
        List<WebElement> checkedBoxes = driver.findElements(By.xpath("//div[contains(@class,'FilterSubSection')][1]//div[contains(@class,'Active')]"));
        for (WebElement checkedBox : checkedBoxes) {
            checkedBox.click();
        }
    }

    public String getNoPostsMessage() {
        Label noPostsFoundLabel = new Label(By.xpath("//div[contains(@class,'eventcalendar_EndOfRows')]"));
        WaitUntil.waitForPresence(noPostsFoundLabel);
        return noPostsFoundLabel.getText();
    }
}
