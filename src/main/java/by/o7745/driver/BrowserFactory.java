package by.o7745.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class BrowserFactory {
    private BrowserFactory() {}

    public static WebDriver createDriver(String browser) {
        return switch (browser) {
            case "firefox" -> firefox();
            case "chrome" -> chrome();
            default -> chrome();
        };
    };

    private static WebDriver chrome() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    };

    private static WebDriver firefox() {
        return new  FirefoxDriver();
    };
}
