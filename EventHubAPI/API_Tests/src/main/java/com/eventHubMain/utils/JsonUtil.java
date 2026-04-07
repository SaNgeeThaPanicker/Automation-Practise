package com.eventHubMain.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static String toJson(Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
