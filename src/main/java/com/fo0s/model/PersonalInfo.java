package com.fo0s.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import static com.fo0s.HelperFile.*;

public class PersonalInfo {
    private static int id;
    private static String firstName;
    private static String lastName;
    private static long overallPoints;
    private static long overallRank;
    private static int currentWeek;
    private static ArrayList<Long> leagueIds;
    private static ArrayList<String> leagueNames;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }

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

        public PersonalInfoBuilder setFirstName(String firstName) {
            this.personalInfo.firstName = firstName;
            return this;
        }

        public PersonalInfoBuilder setLastName(String lastName) {
            this.personalInfo.lastName = lastName;
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
            PersonalInfo.currentWeek = currentWeek;
            return this;
        }

        public PersonalInfoBuilder setLeagueIds(ArrayList<Long> leagueIds) {
            PersonalInfo.leagueIds = leagueIds;
            return this;
        }

        public PersonalInfoBuilder setLeagueNames(ArrayList<String> leagueNames) {
            PersonalInfo.leagueNames = leagueNames;
            return this;
        }

        public PersonalInfoBuilder setId(int id) {
            PersonalInfo.id = id;
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
            leagueIDs.add(playerLeagues.get(i).getAsJsonObject().get("id").getAsLong());
            leagueNames.add(playerLeagues.get(i).getAsJsonObject().get("name").getAsString());
        }

        personalInfo.setId(jsonObject.get(PLAYER_ID).getAsInt());
        personalInfo.setFirstName(jsonObject.get(PLAYER_FIRST_NAME).toString());
        personalInfo.setLastName(jsonObject.get(PLAYER_LAST_NAME).toString());
        personalInfo.setLastName(jsonObject.get(PLAYER_LAST_NAME).toString());
        personalInfo.setOverallPoints(jsonObject.get(PLAYER_OVERALL_POINTS).getAsInt());
        personalInfo.setOverallRank(jsonObject.get(PLAYER_OVERALL_RANK).getAsInt());
        personalInfo.setCurrentWeek(jsonObject.get(PLAYER_CURRENT_WEEK).getAsInt());
        personalInfo.setLeagueIds(leagueIDs);
        personalInfo.setLeagueNames(leagueNames);

        return personalInfo.build();
    }
    public static void personalLeagues() {

    }
}

