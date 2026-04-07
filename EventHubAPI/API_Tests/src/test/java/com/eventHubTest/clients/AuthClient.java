package com.eventHubTest.clients;

import com.eventHubMain.models.LoginRequest;
import com.eventHubMain.utils.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthClient {

    public static Response login(LoginRequest request) {
        return RestAssured
                .given()
                .baseUri(ConfigReader.get("baseUrl"))
                .basePath("/auth")
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }
}
