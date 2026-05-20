package de.check24.tests.api;

import de.check24.api.clients.UserClient;
import de.check24.base.BaseApiTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserApiTest extends BaseApiTest {
    private final UserClient userClient = new UserClient();

    @Test
    @DisplayName("Check user exists API test")
    void checkUserExistsExtendedTest() {
        String csrfToken = "f7a8f73ba236b8e7bac49e77ad74fb1fc754d55c737611f4ef22034fafc07ff8.yfGVAoZ6Hhjv5b23P-CLmUN-Ik2QkTDSv9EU8Ffkg7g";
        String product = "hotel";
        String email = "m1loz0l1wuj3@mailtowin.com";

        Response response = userClient.checkUserExistsExtended(csrfToken, product, email);

        assertThat(response.statusCode())
                .isEqualTo(200);
    }
}
