package main.java.com.eventHubMain.utils;

public class JsonUtil {

    public static String toJson(Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
