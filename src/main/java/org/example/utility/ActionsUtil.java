package org.example.utility;

import org.example.Browser;
import org.example.elements.BaseElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {
    private static final Actions actions = new Actions(Browser.getDriver());
    public static void moveTo(BaseElement element) {
        actions.moveToElement(element.getElement()).perform();
    }

}
