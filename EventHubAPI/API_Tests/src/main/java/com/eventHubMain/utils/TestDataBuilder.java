package com.eventHubMain;
// Reusable helper classes for logging, json parsing or database connections can be added here

    public class TestDataBuilder {

    public static UserRequest createUser() {
        UserRequest user = new UserRequest();
        user.name = "User_" + System.currentTimeMillis();
        user.email = "test" + System.currentTimeMillis() + "@mail.com";
        return user;
    }
}
