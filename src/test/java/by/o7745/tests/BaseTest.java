package by.o7745.tests;

import by.o7745.config.ConfigReader;
import by.o7745.driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public abstract class BaseTest {
    @BeforeEach
    public void setup() {
        log.info("Initializing driver");
        DriverManager.initDriver(ConfigReader.getConfig().browser());
        log.info("Open base page");
        DriverManager.getDriver().get(ConfigReader.getConfig().baseUrl());
    }

    @AfterEach
    public void teardown() {
        log.info("Tearing down driver");
        DriverManager.quitDriver();
    }
}
