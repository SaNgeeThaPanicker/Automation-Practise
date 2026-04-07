package com.eventHubTest.clients;

import com.eventHubMain.utils.ConfigReader;
import com.eventHubTest.base.TokenManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    public static Response post(String path, Object body) {

    RequestSpecification request = RestAssured
            .given()
            .baseUri(ConfigReader.get("baseUrl"))
            .basePath(path)
            .header("Content-Type", "application/json");

    if (!path.contains("/auth/login")) {
        request.header("Authorization", "Bearer " + TokenManager.getToken());
    }

    return request
            .body(body)
            .when()
            .post()
            .then()
            .extract()
            .response();
}

    public static Response get(String path) {

        return RestAssured
                .given()
                .baseUri(ConfigReader.get("baseUrl"))
                .basePath(path)
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .when()
                .get()   
                .then()
                .extract()
                .response();
    }
}