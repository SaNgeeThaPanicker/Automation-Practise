package com.eventHubMain.utils;
import io.qameta.allure.Allure;

public class AllureUtils {

    public static void attachRequest(String name, String request) {
        Allure.addAttachment(name, "application/json", request);
    }

    public static void attachResponse(String name, String response) {
        Allure.addAttachment(name, "application/json", response);
    }
}
