package org.example.pages;

import org.example.Browser;
import org.example.Constants;
import org.example.elements.Link;
import org.example.forms.BaseForm;
import org.example.forms.FooterForm;
import org.example.forms.NavBarForm;
import org.example.utility.PageScroller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseForm {

    public MainPage () {
        super(new Link(By.xpath("//h2[contains(@class,'home_page_content_title')]")));
    }

    public NavBarForm navBarForm = new NavBarForm();

    public FooterForm footerForm = new FooterForm();

    public void scrollToBottom() {
        PageScroller.scrollDown();
    }
}