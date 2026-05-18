package de.check24.elements;

import de.check24.actions.ElementActions;
import org.openqa.selenium.By;

public class BaseElement {
    protected final By locator;
    protected final String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        ElementActions.click(this.locator, this.name);
    }

    public String getText() {
        return ElementActions.getText(this.locator, this.name);
    }

    public boolean isDisplayed() {
        return ElementActions.isDisplayed(this.locator, this.name);
    }


}
