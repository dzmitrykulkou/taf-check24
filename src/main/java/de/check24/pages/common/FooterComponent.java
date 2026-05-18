package de.check24.pages.common;

import de.check24.elements.BaseElement;
import org.openqa.selenium.By;

public class FooterComponent {
    private static final By COPYRIGHT_TEXT_LOCATOR = By.cssSelector("div.c24-footer-company-line");
    private final BaseElement copyrightText = new BaseElement(COPYRIGHT_TEXT_LOCATOR, "Copyright text");

    public String getCopyrightText() {
        return copyrightText.getText();
    }
}
