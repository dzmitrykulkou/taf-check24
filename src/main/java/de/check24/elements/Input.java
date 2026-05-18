package de.check24.elements;

import de.check24.actions.ElementActions;
import org.openqa.selenium.By;

public class Input extends BaseElement {

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void type(String value) {
        ElementActions.type(this.locator, this.name, value);
    }

    public void clear() {
        ElementActions.clear(this.locator, this.name);
    }

    public void clearAndType(String value) {
        ElementActions.clearAndType(this.locator, this.name, value);
    }
}
