package com.eventHubMain.utils;


public class configManager {

    String baseUrl = ConfigReader.get("baseUrl");
    String username = ConfigReader.get("username");
    String password = ConfigReader.get("password");
    String env = ConfigReader.get("env");

    public configManager() {
        if(env.equals("qa")) {
            baseUrl = ConfigReader.get("qaUrl");
        } 
        else if(env.equals("base")) {
            baseUrl = ConfigReader.get("baseUrl");
        }
        else {
            baseUrl = ConfigReader.get("uatUrl");
        }
    }
}

