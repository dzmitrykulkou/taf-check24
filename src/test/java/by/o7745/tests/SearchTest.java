package by.o7745.tests;

import by.o7745.pages.HomePage;
import by.o7745.pages.SearchResultPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("UI Test")
@Feature("Search: check cards")
public class SearchTest extends BaseTest {

    @Test
    public void testSearch() {
        String searchText = "Лопата";
        SearchResultPage searchResultPage = new HomePage()
                .clickAcceptCookieButton()
                .enterSearchText(searchText)
                .clickSearchButton();

        assertThat(searchResultPage.isSearchResultPresent(searchText)).isTrue();
    }
}
