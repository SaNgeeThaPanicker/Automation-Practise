package com.eventHubTest.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.eventHubMain.models.LoginRequest;
import com.eventHubMain.models.LoginResponse;
import com.eventHubMain.utils.ConfigReader;
import com.eventHubTest.base.BaseTest;
import com.eventHubTest.endpoints.AuthEndpoints;
import io.restassured.response.Response;


public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {

        LoginRequest request = new LoginRequest();
        request.setUsername(ConfigReader.get("username"));
        request.setPassword(ConfigReader.get("password"));

        Response response = AuthEndpoints.login(request);

        LoginResponse res = response.as(LoginResponse.class);
        System.out.println(res.getToken());


        response.then().statusCode(200);
        Assert.assertNotNull(res.getToken(), "Token should not be null");
    }
}
