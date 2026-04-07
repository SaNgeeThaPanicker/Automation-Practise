package com.eventHubTest.base;

import com.eventHubMain.models.LoginRequest;
import com.eventHubMain.models.LoginResponse;
import com.eventHubMain.utils.ConfigReader;
import com.eventHubTest.clients.AuthClient;

import io.restassured.response.Response;

public class TokenManager {

    private static String token;

    private static long tokenTime;
    private static final long EXPIRY_TIME = 50 * 60 * 1000; // 50 mins

    public static String getToken() {
        if (token == null || isTokenExpired()) {
            generateToken();
        }
        return token;
    }

    private static boolean isTokenExpired() {
        return System.currentTimeMillis() - tokenTime > EXPIRY_TIME;
    }

    public static void generateToken() {

        tokenTime = System.currentTimeMillis();

        // ✅ Create request body
        LoginRequest request = new LoginRequest();
        request.setUsername(ConfigReader.get("username"));
        request.setPassword(ConfigReader.get("password"));

        // ✅ Call login API
        Response response = AuthClient.login(request);

        // ✅ Extract token
        LoginResponse loginResponse = response.as(LoginResponse.class);
        token = loginResponse.getToken();
    }

    
}