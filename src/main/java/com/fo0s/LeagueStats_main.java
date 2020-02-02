package com.fo0s;;

import com.fo0s.JSON_Helpers.ApiParser;

import com.fo0s.model.PersonalInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import static com.fo0s.HelperFile.*;

class LeagueStats_main
{
    public static void main(String[] args) throws Exception {
        setupData();
    }

    public static void setupData() throws Exception {

        JsonObject player_data = ApiParser.runJSONParser(PERSONAL_INFO + PERSONAL_ID + "/");

        PersonalInfo myInfo =  PersonalInfo.getPersonalInfo(player_data);

        // TODO:
        // Loop through personal leagues and capture info on who is within
        // Loop through each player within each league, call and capture personal info
        // Loop through each player contained, call and capture each gameweek info
        // Start building color coded 'points on bench' chart
        // Export to google sheets

    }

}