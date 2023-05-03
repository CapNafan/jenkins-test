package org.example;

import org.example.elements.Link;
import org.example.pages.MainPage;
import org.example.pages.MostPlayedPage;
import org.example.pages.NewsPage;
import org.example.pages.PrivacyPolicyPage;
import org.example.utility.JsonLoader;
import org.example.utility.TabSwitcher;
import org.example.utility.WaitUntil;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SteamTests extends BaseTest {

    @Test(priority = 1, description = "Privacy Policy page test")
    public void languageListAndRevisionTest() {
        MainPage main = new MainPage();
        main.scrollToBottom();
        main.footerForm.navigateToPrivacyPolicyPage();
        Integer expectedWindowCount = JsonLoader.getExpectedWindowCount();
        Assert.assertEquals(driver.getWindowHandles().size(), expectedWindowCount,
                "Privacy policy page is not open in new tab");
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
        TabSwitcher.switchToPage();
        Assert.assertTrue(privacyPolicyPage.languagesSectionDisplayed(),
                "Could not locate available languages section");
        JSONArray actualJson = privacyPolicyPage.getSupportedLanguages();
        JSONArray expectedJson = JsonLoader.getExpectedLanguages();
        Assert.assertEquals(actualJson, expectedJson,
                "Supported languages does not match test data");
        Assert.assertTrue(privacyPolicyPage.revisionYearIs2023(),
                "invalid policy revision year");
    }

    @Test(priority = 2, description = "Mostly Played page test")
    public void mostPlayedTest() {
        MainPage main = new MainPage();
        Assert.assertTrue(main.isPageOpen(), "Failed to open Steam main page");

        main.navBarForm.navigateToMostPlayedPage();
        MostPlayedPage mostPlayedPage = new MostPlayedPage();
        WaitUntil.waitForPresence(new Link(By.xpath("//div[contains(@class,'steamchartsshell')]//h1")));
        Assert.assertTrue(mostPlayedPage.isPageOpen(), "Failed to open Most played page");

        for (int i = Constants.RANK_ONE; i < Constants.RANK_THREE; i++) {
            Integer previousValue = mostPlayedPage.getCurrentPlayersByRank(i);
            Integer currentValue = mostPlayedPage.getCurrentPlayersByRank(i + 1);
            Assert.assertTrue(previousValue > currentValue, String.format("Number of players in %d place is less or equal to %d place", i, i + 1));
        }
    }

    @Test(priority = 3, description = "News page filter test")
    public void newsFilterTest() {
        MainPage main = new MainPage();
        Assert.assertTrue(main.isPageOpen(), "Failed to open Steam main page");
        main.navBarForm.navigateToNewsPage();

        NewsPage news = new NewsPage();
        Assert.assertTrue(news.isPageOpen(), "Failed to open Steam news page");

        news.enableFilterSection();
        news.uncheckActiveCheckboxes();
        String expectedNoPostsMessage = JsonLoader.getExpectedNoPostsText();
        Assert.assertEquals(news.getNoPostsMessage(), expectedNoPostsMessage.toUpperCase(), "Expected message not displayed");
    }
}