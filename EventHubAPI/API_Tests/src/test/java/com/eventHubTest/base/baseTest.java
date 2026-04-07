package com.eventHubTest.base;
import org.testng.annotations.BeforeClass;

import com.eventHubMain.utils.ConfigReader;
import io.restassured.RestAssured; 


public class BaseTest {

    protected static String token;

    @BeforeClass
    public void setup() {
      token = TokenManager.getToken();
      RestAssured.baseURI = ConfigReader.get("baseUrl");
    }
}
