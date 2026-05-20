package by.o7745.elements;

import org.openqa.selenium.By;

public class BaseElement {
    protected By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }
}
