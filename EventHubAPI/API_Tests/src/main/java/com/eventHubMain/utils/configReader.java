package com.eventHubMain.utils;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties(); 

    static {
        try {
            prop = new Properties();
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public static void set(String string, String token) {
        prop.setProperty(string, token);
    }
}
