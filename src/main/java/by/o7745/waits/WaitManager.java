package by.o7745.waits;

import by.o7745.config.ConfigReader;
import by.o7745.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class WaitManager {
    private WaitManager() {}

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(ConfigReader.getConfig().timeout()));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static List<WebElement> waitForVisibilityOfAllElements(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
