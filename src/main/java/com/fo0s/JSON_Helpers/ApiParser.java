package com.fo0s.JSON_Helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiParser {

    public static JsonObject runJSONParser(String apiReference) throws Exception {
        //Read from the URL later
        String fileData = CallAPI.getJsonData(apiReference);

        return new JsonParser().parse(fileData).getAsJsonObject();
    }
}
