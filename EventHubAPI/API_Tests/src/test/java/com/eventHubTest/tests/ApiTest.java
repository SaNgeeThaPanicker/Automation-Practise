package com.eventHubTest.tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    // public static void main(String[] args) {
    //     try {
    //         URL url = new URL("https://reqres.in/api/test?id=4");
    //         HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    //         conn.setRequestMethod("GET");
    //         conn.connect();

    //         int statusCode = conn.getResponseCode();
    //         System.out.println("Status Code: " + statusCode);

    //         BufferedReader reader = new BufferedReader(
    //             new InputStreamReader(conn.getInputStream())
    //         );

    //         String line;
    //         StringBuilder response = new StringBuilder();

    //         while ((line = reader.readLine()) != null) {
    //             response.append(line);
    //         }

    //         reader.close();

    //         System.out.println("Response: " + response.toString());

    //         // Basic validation
    //         if (statusCode == 200) {
    //             System.out.println("Test Passed");
    //         } else {
    //             System.out.println("Test Failed");
    //         }

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }


// public class ApiTestByRestAssured {
    public static void main(String[] args) {

        given()
        .queryParam("id", 4)
        .when()
        .get("https://reqres.in/api/test")
        .then()
        .statusCode(401)
        .log().all();
    }
}
