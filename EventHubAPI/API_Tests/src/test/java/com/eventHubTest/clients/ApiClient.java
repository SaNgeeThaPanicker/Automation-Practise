package com.eventHubTest.clients;
import com.eventHubMain.utils.AllureUtils;
import com.eventHubMain.utils.ConfigReader;
import com.eventHubTest.base.TokenManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    public static Response post(String path, Object body) {

        String requestBody = body.toString();

        AllureUtils.attachRequest("POST Request", requestBody);

        Response response = RestAssured
                .given()
                .baseUri(ConfigReader.get("baseUrl"))
                .basePath(path)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post();

        AllureUtils.attachResponse("Response", response.asPrettyString());

        return response;
    }

    public static Response get(String path) {

        AllureUtils.attachRequest("GET Request", "GET " + path);

        Response response = RestAssured
                .given()
                .baseUri(ConfigReader.get("baseUrl"))
                .basePath(path)
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .when()
                .get()
                .then()
                .extract()
                .response();

        AllureUtils.attachResponse("GET Response", response.asPrettyString());

        return response;

    }
}