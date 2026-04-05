package com.eventHubMain;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/test/resources/config.properties"
            ); 
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
