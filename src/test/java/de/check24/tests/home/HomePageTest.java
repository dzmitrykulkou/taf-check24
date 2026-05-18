package de.check24.tests.home;

import de.check24.base.BaseTest;
import de.check24.steps.HomeSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Web UI Tests")
@Feature("Home page")
public class HomePageTest extends BaseTest {

    @Test
    @Story("User can see the copyright text on the home page")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify that a user can open the home page, dismiss cookies, and see the copyright text")
    @DisplayName("Home test: Copyright text")
    public void homeTest() {
        final String expectedCopyrightText = "CHECK24 Vergleichsportal GmbH München";

        HomeSteps homeSteps = new HomeSteps()
                .openHomePageAndDismissCookie();

        assertThat(homeSteps.getCopyrightText())
                .contains(expectedCopyrightText);
    }
}
