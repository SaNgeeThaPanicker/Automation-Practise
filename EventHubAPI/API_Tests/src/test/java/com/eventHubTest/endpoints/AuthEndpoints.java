package com.eventHubTest.endpoints;

import com.eventHubMain.models.LoginRequest;
import com.eventHubTest.clients.ApiClient;
import io.restassured.response.Response;

public class AuthEndpoints {

    private static final String LOGIN_PATH = "/auth";

    public static Response login(LoginRequest request) {
        return ApiClient.post(LOGIN_PATH, request);
    }
}