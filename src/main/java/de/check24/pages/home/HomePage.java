package de.check24.pages.home;

import de.check24.pages.BasePage;
import de.check24.pages.common.HeaderComponent;
import lombok.Getter;

public class HomePage extends BasePage {
    @Getter
    private final HeaderComponent headerComponent = new HeaderComponent();

    public void search(String searchText) {
        headerComponent.fillSearchInput(searchText);
        headerComponent.clickSearchButton();
    }

}
