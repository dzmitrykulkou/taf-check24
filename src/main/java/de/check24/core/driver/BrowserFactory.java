package de.check24.core.driver;

import de.check24.core.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;

public final class BrowserFactory {
    private BrowserFactory() {}

    public static WebDriver createDriver(BrowserType browser, boolean isHeadless) {
        return switch (browser) {
            case CHROME -> chrome(isHeadless);
            case FIREFOX -> firefox();
        };
    }

    private static WebDriver chrome(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");

        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        return new ChromeDriver(options);
    }

    private static WebDriver firefox() {
        return new FirefoxDriver();
    }
}
