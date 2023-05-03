package org.example.forms;

import org.example.Constants;
import org.example.elements.Link;
import org.example.utility.ActionsUtil;
import org.example.utility.WaitUntil;
import org.openqa.selenium.By;

public class NavBarForm extends BaseForm {

    public NavBarForm() {
        super(new Link(By.xpath("//div[contains(@id,'store_nav_area')]")));
    }

    public void navigateToMostPlayedPage() {
        Link newAndNoteworthy = new Link(By.xpath("//div[contains(@id,'noteworthy_tab')]"));
        ActionsUtil.moveTo(newAndNoteworthy);
        Link mostPlayedLink = new Link(By.xpath("//a[contains(@href,'mostplayed')]"));
        WaitUntil.waitToBeClickable(mostPlayedLink);
        mostPlayedLink.click();
    }

    public void navigateToNewsPage() {
        Link newsLink = new Link(By.xpath("//div[contains(@class,'store_nav')]//a[contains(@href,'news/')]"));
        newsLink.click();
        WaitUntil.waitForPresence(new Link(By.xpath("//div[contains(@class,'FilterLink')]")));
    }
}
