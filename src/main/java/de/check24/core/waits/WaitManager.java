package de.check24.core.waits;

import de.check24.core.config.ConfigReader;
import de.check24.core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitManager {
    private WaitManager() {}

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(ConfigReader.CONFIG.timeout()));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForVisibility(By locator, int seconds) {
        try {
            new  WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static WebElement waitForClickability(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForInvisibility(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
