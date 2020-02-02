package com.fo0s.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import static com.fo0s.HelperFile.*;

public class PersonalInfo {
    private static int id;
    private static String playerName;
    private static long overallPoints;
    private static long overallRank;
    private static int currentWeek;
    private static ArrayList<Long> leagueIds;
    private static ArrayList<String> leagueNames;

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public long getOverallPoints() {
        return overallPoints;
    }

    public long getOverallRank() {
        return overallRank;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public ArrayList<Long> getLeagueIds() {
        return leagueIds;
    }

    public ArrayList<String> getLeagueNames() {
        return leagueNames;
    }

    public static class PersonalInfoBuilder {
        private PersonalInfo personalInfo = new PersonalInfo();

        public PersonalInfoBuilder setPlayerName(String firstName) {
            this.personalInfo.playerName = firstName;
            return this;
        }

        public PersonalInfoBuilder setOverallPoints(long overallPoints) {
            this.personalInfo.overallPoints = overallPoints;
            return this;
        }

        public PersonalInfoBuilder setOverallRank(long overallRank) {
            this.personalInfo.overallRank = overallRank;
            return this;
        }

        public PersonalInfoBuilder setCurrentWeek(int currentWeek) {
            this.personalInfo.currentWeek = currentWeek;
            return this;
        }

        public PersonalInfoBuilder setLeagueIds(ArrayList<Long> leagueIds) {
            this.personalInfo.leagueIds = leagueIds;
            return this;
        }

        public PersonalInfoBuilder setLeagueNames(ArrayList<String> leagueNames) {
            this.personalInfo.leagueNames = leagueNames;
            return this;
        }

        public PersonalInfoBuilder setId(int id) {
            this.personalInfo.id = id;
            return this;
        }

        public PersonalInfo build() { return this.personalInfo; }
    }

    public static PersonalInfo getPersonalInfo(JsonObject jsonObject) {

        JsonArray playerLeagues = jsonObject.getAsJsonObject("leagues").getAsJsonArray("classic");
        ArrayList<Long> leagueIDs = new ArrayList<>();
        ArrayList<String> leagueNames = new ArrayList<>();

        PersonalInfo.PersonalInfoBuilder personalInfo = new PersonalInfo.PersonalInfoBuilder();

        for(int i = 4; i < playerLeagues.size(); i++) {
            leagueIDs.add(playerLeagues.get(i).getAsJsonObject().get(PLAYER_ID).getAsLong());
            leagueNames.add(playerLeagues.get(i).getAsJsonObject().get(DEFAULT_NAME).getAsString());
        }

        personalInfo.setId(jsonObject.get(PLAYER_ID).getAsInt());
        personalInfo.setPlayerName(jsonObject.get(PLAYER_FIRST_NAME).toString() +" "+
                jsonObject.get(PLAYER_LAST_NAME).toString());
        personalInfo.setOverallPoints(jsonObject.get(PLAYER_OVERALL_POINTS).getAsInt());
        personalInfo.setOverallRank(jsonObject.get(PLAYER_OVERALL_RANK).getAsInt());
        personalInfo.setCurrentWeek(jsonObject.get(PLAYER_CURRENT_WEEK).getAsInt());
        personalInfo.setLeagueIds(leagueIDs);
        personalInfo.setLeagueNames(leagueNames);

        return personalInfo.build();

    }
}

