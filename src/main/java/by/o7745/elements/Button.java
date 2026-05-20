package by.o7745.elements;

import by.o7745.actions.ElementAction;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class Button extends BaseElement{
    public Button(By locator) {
        super(locator);
    }

    public void click() {
        log.info("Clicking on button {}", locator);
        ElementAction.click(locator);
    }
}
