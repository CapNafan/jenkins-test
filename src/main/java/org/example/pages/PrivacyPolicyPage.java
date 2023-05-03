package org.example.pages;

import org.example.Browser;
import org.example.Constants;
import org.example.elements.Label;
import org.example.elements.Link;
import org.example.forms.BaseForm;
import org.example.utility.*;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PrivacyPolicyPage extends BaseForm {
    private final WebDriver driver = Browser.getDriver();

    public PrivacyPolicyPage() {
        super(new Link(By.xpath("//div//text()[contains(.,'Privacy Policy Agreement')]")));
    }

    public boolean languagesSectionDisplayed() {
        Label languageSwitcher = new Label(By.xpath("//div[@id='languages']"));
        WaitUntil.waitForPresence(languageSwitcher);
        return languageSwitcher.isDisplayed();
    }

    public JSONArray getSupportedLanguages() {
        List<String> languageList = new ArrayList<>();
        for (WebElement languageLink : driver.findElements(By.xpath("//div[@id='languages']//a"))) {
            String uriString = languageLink.getAttribute("href");
            String language = LinkParser.getLanguageFromUri(uriString);
            languageList.add(language);
        }
        return JsonBuilder.buildJsonFromLanguagesList(languageList);
    }

    public boolean revisionYearIs2023() {
        Label revisionYear = new Label(By.xpath(String.format("//div[@id='newsColumn']//i[contains(text(),'%d')]", DateUtil.getCurrentYear())));
        return revisionYear.isDisplayed();
    }
}