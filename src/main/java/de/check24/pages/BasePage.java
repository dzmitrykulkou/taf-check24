package de.check24.pages;

import de.check24.elements.Button;
import org.openqa.selenium.By;

public abstract class BasePage {
    private static final By DISMISS_COOKIE_LOCATOR = By.cssSelector("a.c24-cookie-consent-functional");
    private final Button dismissCookieButton = new Button(DISMISS_COOKIE_LOCATOR, "Dismiss cookie button");

    public void dismissCookie() {
        dismissCookieButton.click();
    }
}
