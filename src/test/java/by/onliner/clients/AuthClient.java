package by.onliner.clients;

import by.onliner.models.LoginRequest;
import io.restassured.response.Response;

import static by.onliner.specs.ReqSpec.loginSpec;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response login(LoginRequest requestBody) {
        return given()
                .spec(loginSpec())
                .body(requestBody)
                .post();
    }
}
