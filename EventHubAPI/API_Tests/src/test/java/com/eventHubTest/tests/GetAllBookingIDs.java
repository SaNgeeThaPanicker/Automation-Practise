package com.eventHubTest.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eventHubTest.endpoints.GetAllBookingIDEndpoint;

import io.restassured.response.Response;

public class GetAllBookingIDs {

@Test
public void testGetAllBookingIDs() {
    Response response = GetAllBookingIDEndpoint.getBookingID();
    System.out.println(response.prettyPrint());

    response.then()
            .statusCode(200);
            // .time(lessThan(3000L)); // performance check

    List<Integer> bookingIds = response.jsonPath().getList("bookingid");

    Assert.assertNotNull(bookingIds);
    Assert.assertTrue(bookingIds.size() > 0);

    // Validate all IDs are positive
    bookingIds.forEach(id -> Assert.assertTrue(id > 0));
}
}
