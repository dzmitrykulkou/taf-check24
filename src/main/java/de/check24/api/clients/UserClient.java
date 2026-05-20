package de.check24.api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String EXISTS_EXTENDED_PATH = "/login/api/user/existsextended/";
    private static final String CSRF_TOKEN_PATH = "login/api/csrftoken/";
    private static final String AUTH_PROCESS_START_PATH =  "login/api/user/authprocessstart/";
    private static final String AUTH_PROCESS_CONTINUE_PATH =  "login/api/user/authprocesscontinue/";
    private static final String CSRF_TOKEN = getCsrfToken();

    public Response checkUserExistsExtended(String product, String email) {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("csrf_token", CSRF_TOKEN)
                .formParam("product", product)
                .formParam("csrf_token", CSRF_TOKEN)
                .formParam("a", email)
                .post(EXISTS_EXTENDED_PATH);
    }

    private static String getCsrfToken() {
        return given()
                .post(CSRF_TOKEN_PATH)
                .getBody()
                .jsonPath()
                .getString("csrfToken");
    }

    public Response firstPasswordRequest(String authType, String email) {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("csrf_token", CSRF_TOKEN)
                .formParam("auth_type", authType)
                .formParam("csrf_token", CSRF_TOKEN)
                .formParam("login", email)
                .post(AUTH_PROCESS_START_PATH);
    }

    public String getUUID(Response response) {
        return response.jsonPath().getString("data.authprocessinstance_uuid");
    }

    public Response secondPasswordRequest(String uuid) {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("csrf_token", CSRF_TOKEN)
                .formParam("uuid", uuid)
                .formParam("csrf_token", CSRF_TOKEN)
                .formParam("token", "")
                .post(AUTH_PROCESS_CONTINUE_PATH);
    }
}
