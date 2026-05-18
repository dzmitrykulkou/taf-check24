package de.check24.pages.common;

import de.check24.elements.Button;
import de.check24.elements.Input;
import org.openqa.selenium.By;

public class HeaderComponent {
    private static final By SEARCH_INPUT_LOCATOR = By.name("q");
    private static final By SEARCH_BUTTON_LOCATOR = By.className("c24-search-button");
    private final Input searchInput = new Input(SEARCH_INPUT_LOCATOR, "Search input");
    private final Button searchButton = new Button(SEARCH_BUTTON_LOCATOR, "Search button");

    public void fillSearchInput(String text) {
        searchInput.type(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }


}
