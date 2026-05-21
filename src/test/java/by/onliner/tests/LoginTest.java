package by.onliner.tests;

import by.onliner.clients.AuthClient;
import by.onliner.models.LoginRequest;
import by.onliner.models.LoginResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    private final AuthClient authClient = new AuthClient();
    private static final String EMALE = "tnhdwstnh@gmail.com";
    private static final String PASSWORD = "************";
    private static final String WRONG_PASSWORD = "invalid321";

    @Test
    public void shouldNotLoginWithInvalidPassword() {
        LoginRequest rq = LoginRequest.builder()
                .login(EMALE)
                .password(WRONG_PASSWORD)
                .build();

        Response response = authClient.login(rq);

        assertThat(response.getStatusCode()).isEqualTo(400);

        LoginResponse rs = response.as(LoginResponse.class);

        assertThat(rs.getErrors().getFirst().getKey())
                .isEqualTo("invalid_login_or_password");
    }

    @Test
    public void shouldLoginWithValidPassword() {
        LoginRequest rq = LoginRequest.builder()
                .login(EMALE)
                .password(PASSWORD)
                .build();

        Response response = authClient.login(rq);

        assertThat(response.getStatusCode()).isEqualTo(200);

        LoginResponse rs = response.as(LoginResponse.class);

        assertThat(rs.getAccessToken())
                .isNotNull();
    }
}
