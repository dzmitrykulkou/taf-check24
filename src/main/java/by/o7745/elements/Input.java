package by.o7745.elements;

import by.o7745.actions.ElementAction;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class Input extends BaseElement {

    public Input(By locator) {
        super(locator);
    }

    public void enterText(String text) {
        log.info("Entering text '{}' into {}", text, locator);
        ElementAction.setText(locator, text);
    }
}
