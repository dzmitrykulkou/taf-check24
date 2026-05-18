package de.check24.base;

import de.check24.core.driver.BrowserFactory;
import de.check24.core.config.ConfigReader;
import de.check24.core.driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public abstract class BaseTest {
    @BeforeEach
    public void setup() {
        DriverManager.setDriver(BrowserFactory.createDriver(
                ConfigReader.CONFIG.browser(),
                ConfigReader.CONFIG.headless()
        ));
        log.info("Starting test on browser: {}\n Headless mode: {}",
                ConfigReader.CONFIG.browser(),  ConfigReader.CONFIG.headless());
    }

    @AfterEach
    public void teardown() {
        DriverManager.closeDriver();
    }
}
