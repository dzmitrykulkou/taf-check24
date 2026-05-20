package by.o7745.pages;

import by.o7745.elements.ElementsList;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultPage {
    private final ElementsList searchResults = new ElementsList(By.cssSelector(".item-block"));

    private List<String> getSearchResultTexts() {
        return searchResults.getTexts();
    }

    public boolean isSearchResultPresent(String expectedText) {
        for(String text : getSearchResultTexts()) {
            if(!text.contains(expectedText)) return false;
        }
        return true;
    }
}
