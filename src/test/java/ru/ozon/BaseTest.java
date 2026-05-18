package ru.ozon;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.ozon.driver.DriverManager;

@Slf4j
public abstract class BaseTest {
    @BeforeEach
    public void setUp() {
        log.info("Init driver");
        DriverManager.initDriver("chrome", false);
        log.info("Open home page");
        DriverManager.getDriver().get("https://www.ozon.ru/");
    }

    @AfterEach
    public void tearDown() {
        log.info("Close driver");
        DriverManager.closeDriver();
    }
}
