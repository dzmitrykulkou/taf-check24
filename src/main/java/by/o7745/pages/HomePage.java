package by.o7745.pages;

import by.o7745.elements.Button;
import by.o7745.elements.Input;
import org.openqa.selenium.By;

public class HomePage {
    private final Button acceptCookieButton = new Button(By.id("dldkdAccept"));
    private final Input searchInput = new Input(By.id("search"));
    private final Button searchButton = new Button(By.className("btn-search"));

    public HomePage clickAcceptCookieButton() {
        acceptCookieButton.click();
        return this;
    }

    public HomePage enterSearchText(String text) {
        searchInput.enterText(text);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage();
    }
}
