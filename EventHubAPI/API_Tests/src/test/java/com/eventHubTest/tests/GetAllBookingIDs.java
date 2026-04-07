package com.eventHubTest.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eventHubMain.utils.AllureUtils;
import com.eventHubTest.base.BaseTest;
import com.eventHubTest.endpoints.GetAllBookingIDEndpoint;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class GetAllBookingIDs extends BaseTest {

    @Test
    @Step("Get all booking IDs")
    @Epic("Booking API")
    @Feature("Booking Retrieval")
    @Story("Get All Booking IDs")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetAllBookingIDs() {

        Response response = GetAllBookingIDEndpoint.getBookingID();
        response.then()
                .statusCode(200);
        // .time(lessThan(3000L)); // performance check

        try {
            response.then().statusCode(200);
        } catch (AssertionError e) {
            AllureUtils.attachResponse("Failure Response", response.asPrettyString());
            throw e;
        }

        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        for (Integer id : bookingIds) {
            System.out.println("Booking ID: " + id);
        }

        Assert.assertNotNull(bookingIds);
        Assert.assertTrue(bookingIds.size() > 0);

        // Validate all IDs are positive
        bookingIds.forEach(id -> Assert.assertTrue(id > 0));
    }
}
