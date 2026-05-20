package de.check24.api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String EXISTS_EXTENDED_PATH = "/login/api/user/existsextended/";

    public Response checkUserExistsExtended(String csrfToken, String product, String email) {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("csrf_token", csrfToken)
                .formParam("product", product)
                .formParam("csrf_token", csrfToken)
                .formParam("a", email)
                .post(EXISTS_EXTENDED_PATH);
    }
}
