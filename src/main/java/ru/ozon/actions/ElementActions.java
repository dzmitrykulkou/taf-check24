package ru.ozon.actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import ru.ozon.driver.DriverManager;
import ru.ozon.waits.WaitManager;

@Slf4j
public final class ElementActions {
    private ElementActions() {}

    public static String getText(By locator) {
        log.info("Getting text for {}", locator);
        return WaitManager.waitForVisibility(locator).getText();
    }
}
