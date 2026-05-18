package ru.ozon.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {};

    public static void initDriver(String browser, boolean headless) {
        driver.set(BrowserFactory.createDriver(browser, headless));
    }

    public static WebDriver getDriver() {
        return driver.get();
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
