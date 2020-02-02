package com.fo0s.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import static com.fo0s.HelperFile.*;

public class LeagueInfo {
    private static String leagueName;
    private static long leagueId;
    private static ArrayList<Long> playerIds;
    private static ArrayList<String> playerNames;
    private static ArrayList<String> playerHandles;

    public static String getLeagueName() {
        return leagueName;
    }

    public static long getLeagueId() {
        return leagueId;
    }

    public static ArrayList<Long> getPlayerIds() {
        return playerIds;
    }

    public static ArrayList<String> getPlayerNames() {
        return playerNames;
    }

    public static ArrayList<String> getPlayerHandles() {
        return playerHandles;
    }

    public static class LeagueInfoBuilder {
        private LeagueInfo leagueInfo = new LeagueInfo();

        public LeagueInfoBuilder setLeagueName(String leagueName) {
            this.leagueInfo.leagueName = leagueName;
            return this;
        }

        public LeagueInfoBuilder setLeagueId(long leagueId) {
            this.leagueInfo.leagueId = leagueId;
            return this;
        }

        public LeagueInfoBuilder setPlayerIds(ArrayList<Long> playerIds) {
            this.leagueInfo.playerIds = playerIds;
            return this;
        }

        public LeagueInfoBuilder setPlayerNames(ArrayList<String> playerNames) {
            this.leagueInfo.playerNames = playerNames;
            return this;
        }

        public LeagueInfoBuilder setPlayerHandles(ArrayList<String> playerHandles) {
            this.leagueInfo.playerHandles = playerHandles;
            return this;
        }

        public LeagueInfo build() { return this.leagueInfo; }
    }

    public static LeagueInfo getLeagueInfo(JsonObject jsonObject) {
        JsonArray playerLeagues = jsonObject.getAsJsonObject("standings").getAsJsonArray("results");

        ArrayList<Long> playerIds = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<String> playerHandles = new ArrayList<>();

        LeagueInfoBuilder leagueInfo = new LeagueInfoBuilder();

        for(int i = 0; i < playerLeagues.size(); i++) {
            playerIds.add(playerLeagues.get(i).getAsJsonObject().get(PLAYER_ID).getAsLong());
            playerNames.add(playerLeagues.get(i).getAsJsonObject().get(LEAGUE_PLAYER_NAME).getAsString());
            playerHandles.add(playerLeagues.get(i).getAsJsonObject().get(LEAGUE_PLAYER_HANDLE).getAsString());
        }

        leagueInfo.setLeagueName(jsonObject.get(DEFAULT_NAME).toString());
        leagueInfo.setLeagueId(jsonObject.get(PLAYER_ID).getAsInt());
        leagueInfo.setPlayerIds(playerIds);
        leagueInfo.setPlayerNames(playerNames);
        leagueInfo.setPlayerHandles(playerHandles);

        return leagueInfo.build();
    }

}
