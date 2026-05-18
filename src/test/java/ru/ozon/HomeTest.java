package ru.ozon;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ozon.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("UI Tests")
@Feature("Home page: Check header icons")
public class HomeTest extends  BaseTest {

    @DisplayName("Check icon text")
    @ParameterizedTest
    @ValueSource(strings = {"Войти", "Заказы", "Избранное", "Корзина"})
    public void testHomePageHeaderIcon(String expected) {
        assertThat(new HomePage().getTextHeaderIcon(expected))
                .isEqualTo(expected);
    }
}
