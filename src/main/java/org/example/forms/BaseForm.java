package org.example.forms;

import org.example.elements.BaseElement;

public abstract class BaseForm {

    private final BaseElement uniqueElement;

    public BaseForm(BaseElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public boolean isPageOpen() {
        return uniqueElement.isDisplayed();
    }

}
