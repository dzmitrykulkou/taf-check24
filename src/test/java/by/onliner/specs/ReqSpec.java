package by.onliner.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqSpec {
    public static RequestSpecification loginSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://www.onliner.by/")
                .setBasePath("sdapi/user.api/login")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
