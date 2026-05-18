package de.check24.core.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static void setDriver(WebDriver webDriver) {
        if (driver.get() == null) {
            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver == null) {
            throw new RuntimeException("Driver is not initialized! Call setDriver() before usage.");
        }
        return webDriver;
    }

    public static void closeDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            try {
                webDriver.quit();
            } finally {
                driver.remove();
            }
        }
    }
}
