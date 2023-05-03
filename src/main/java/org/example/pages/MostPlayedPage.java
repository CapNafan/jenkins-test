package org.example.pages;

import org.example.Browser;
import org.example.Constants;
import org.example.elements.Label;
import org.example.forms.BaseForm;
import org.example.utility.StringUtil;
import org.example.utility.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MostPlayedPage extends BaseForm {

    private final WebDriver driver = Browser.getDriver();

    public MostPlayedPage () {
        super(new Label(By.xpath("//div[contains(@class,'steamchartsshell')]//h1")));
    }

    public Integer getCurrentPlayersByRank(Integer rank) {
        String rawPlayersString = getAllTopSellers().get(rank - 1).getText();
        String currentPlayersString = StringUtil.removeCommas(rawPlayersString);
        return Integer.parseInt(currentPlayersString);
    }

    private List<WebElement> getAllTopSellers() {
        WaitUntil.waitForPresence(new Label(By.xpath("//td[contains(@class,'ConcurrentCell')]")));
        return driver.findElements(By.xpath("//td[contains(@class,'ConcurrentCell')]"));
    }
}
