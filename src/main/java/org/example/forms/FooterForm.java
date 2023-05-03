package org.example.forms;

import org.example.Constants;
import org.example.elements.Link;
import org.openqa.selenium.By;

public class FooterForm extends BaseForm {

    private final Link privacyPolicyLink = new Link(By.xpath("//div[@id='footer_text']//div//a[contains(@href,'privacy_agreement')]"));

    public FooterForm() {
        super(new Link(By.xpath("//div[contains(@id,'footer_logo')]")));
    }

    public void navigateToPrivacyPolicyPage() {
        privacyPolicyLink.click();
    }
}
