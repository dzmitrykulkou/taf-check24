package by.o7745.actions;

import by.o7745.waits.WaitManager;
import org.openqa.selenium.By;

public final class ElementAction {

    private ElementAction() {}

    public static void click(By locator) {
        WaitManager.waitForClickability(locator).click();
    }

    public static void setText(By locator, String text) {
        WaitManager.waitForVisibility(locator).sendKeys(text);
    }

    public static String getText(By locator) {
        return WaitManager.waitForVisibility(locator).getText();
    }

    public static java.util.List<String> getElementsText(By locator) {
        return WaitManager.waitForVisibilityOfAllElements(locator).stream()
                .map(org.openqa.selenium.WebElement::getText)
                .collect(java.util.stream.Collectors.toList());
    }
}
