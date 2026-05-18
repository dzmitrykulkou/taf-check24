package de.check24.steps;

import de.check24.core.driver.DriverManager;

public abstract class BaseSteps {
    public String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

}
