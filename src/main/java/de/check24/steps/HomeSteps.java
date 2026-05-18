package de.check24.steps;

import de.check24.core.config.ConfigReader;
import de.check24.core.driver.DriverManager;
import de.check24.pages.home.HomePage;

public class HomeSteps extends BaseSteps {
    private final HomePage homePage = new HomePage();

    public HomeSteps openHomePageAndDismissCookie() {
        DriverManager.getDriver().get(ConfigReader.CONFIG.baseUrl());
        homePage.dismissCookie();
        return this;
    }

    public void search(String searchText) {
        homePage.search(searchText);
    }

    public String getCopyrightText() {
        return homePage.getCopyrightText();
    }
}
