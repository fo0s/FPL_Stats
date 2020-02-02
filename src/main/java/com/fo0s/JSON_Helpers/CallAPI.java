package com.fo0s.JSON_Helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CallAPI {

    public static String getJsonData(String url) throws Exception {
        if(url.isEmpty()) throw new Exception("No URL supplied");

        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}