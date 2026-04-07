package com.eventHubTest.endpoints;

import com.eventHubTest.clients.ApiClient;

import io.restassured.response.Response;

public class GetAllBookingIDEndpoint {

    private static final String BOOKING_ID_PATH = "/booking";

    public static Response getBookingID() {
        return ApiClient.get(BOOKING_ID_PATH);
    }

}
