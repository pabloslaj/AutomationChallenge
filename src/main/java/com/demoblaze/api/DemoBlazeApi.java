package com.demoblaze.api;

import com.demoblaze.api.fixtures.entity.UserDetailsData;
import com.demoblaze.config.factory.ApiConfigFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class DemoBlazeApi {

    private DemoBlazeApi() {
    }

    private static final String URL = ApiConfigFactory.getConfig().url();
    private static final String SIGN_UP = ApiConfigFactory.getConfig().signUpEndpoint();
    private static final String LOGIN = ApiConfigFactory.getConfig().loginEndpoint();

    public static Response createUser(UserDetailsData userDetails) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .body(userDetails)
                .post(SIGN_UP);
    }

    public static Response login(UserDetailsData userDetails) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .body(userDetails)
                .post(LOGIN);
    }


}
