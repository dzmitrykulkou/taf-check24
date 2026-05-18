package de.check24.actions;

import de.check24.core.waits.WaitManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Slf4j
public final class ElementActions {
    private ElementActions() {}

    private static WebElement getElement(By locator) {
        return WaitManager.waitForVisibility(locator);
    }

    public static void click(By locator, String name) {
        log.info("Clicking on {}", name);
        WaitManager.waitForClickability(locator).click();
    }

    public static String getText(By locator, String name) {
        log.info("Getting text on {}", name);
        return getElement(locator).getText();
    }

    public static boolean isDisplayed(By locator, String name) {
        log.info("Checking if element is displayed {}", name);
        return WaitManager.waitForVisibility(locator, 2);
    }

    public static void type(By locator, String name, String value) {
        log.info("Typing {} in {}",  value, name);
        getElement(locator).sendKeys(value);
    }

    public static void clear(By locator, String name) {
        log.info("Clearing in {}",  name);
        getElement(locator).clear();
    }

    public static void clearAndType(By locator, String name, String value) {
        log.info("Clearing in {} and type {}",  name, value);
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(value);
    }
}
