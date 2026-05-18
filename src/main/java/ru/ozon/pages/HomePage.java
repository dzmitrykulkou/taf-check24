package ru.ozon.pages;

import org.openqa.selenium.By;
import ru.ozon.actions.ElementActions;

public class HomePage {
    private static final By PROFILE_MENU_LOCATOR = By.cssSelector("[data-widget='profileMenuAnonymous']");
    private static final By ORDER_INFO_LOCATOR = By.cssSelector("[data-widget='orderInfo']");
    private static final By FAVORITE_COUNTER_LOCATOR = By.cssSelector("[data-widget='favoriteCounter']");
    private static final By HEADER_ICON_LOCATOR = By.cssSelector("[data-widget='headerIcon']");

    public String getTextHeaderIcon(String icon) {
        return switch(icon) {
            case "Войти" -> ElementActions.getText(PROFILE_MENU_LOCATOR);
            case "Заказы" -> ElementActions.getText(ORDER_INFO_LOCATOR);
            case "Избранное" ->  ElementActions.getText(FAVORITE_COUNTER_LOCATOR);
            case "Корзина" ->  ElementActions.getText(HEADER_ICON_LOCATOR);
            default -> "Element doesn't exist";
        };
    }
}
