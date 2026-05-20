package de.check24.tests.api;

import de.check24.api.clients.UserClient;
import de.check24.base.BaseApiTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserApiTest extends BaseApiTest {
    private final UserClient userClient = new UserClient();
    private static final String email = "m1loz0l1wuj3@mailtowin.com";

    @Test
    @DisplayName("Check user exists API test")
    void checkUserExistsExtendedTest() {
        String product = "hotel";
        Response response = userClient.checkUserExistsExtended(product, email);

        assertThat(response.statusCode())
                .isEqualTo(200);
    }

    @Test
    @DisplayName("Auth processes")
    void testAuthProcesses() {
        String authType = "password_v3";
        Response response1 = userClient
                .firstPasswordRequest(authType, email);

        assertThat(response1.statusCode()).isEqualTo(200);

        String uuid = userClient.getUUID(response1);

        Response response2 = userClient
                .secondPasswordRequest(uuid);

        assertThat(response2.statusCode()).isEqualTo(200);
    }
}
