package ru.ozon.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;

public final class BrowserFactory {
    private BrowserFactory() {}

    public static WebDriver createDriver(String browser, boolean headless) {
        return switch (browser) {
            case "chrome" -> chrome(headless);
            case "firefox" -> firefox(headless);
            default -> chrome(headless);
        };
    }

    private static WebDriver chrome(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        } else {
            options.addArguments("--start-maximized");
        }

        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        options.addArguments("--disable-blink-features=AutomationControlled");

        return new ChromeDriver(options);
    }

    private static WebDriver firefox(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
        } else {
            options.addArguments("--start-maximized");
        }

        return new FirefoxDriver(options);
    }
}
