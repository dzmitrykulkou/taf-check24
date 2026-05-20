package by.o7745.elements;

import by.o7745.actions.ElementAction;
import org.openqa.selenium.By;

import java.util.List;

public class ElementsList extends BaseElement {
    public ElementsList(By locator) {
        super(locator);
    }

    public List<String> getTexts() {
        return ElementAction.getElementsText(locator);
    }
}
