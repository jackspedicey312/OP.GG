package data_access;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.Math.round;

public class RiotAPIRankDataAccess {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    private String gameMode;
    private String rank;
    private String division;
    private int leaguePoints;
    private int wins;
    private int losses;
    private int winRate;

    public void generateRank(String summonerID, String region) throws IOException {
        final HttpURLConnection request = getHttpURLConnection(summonerID, region);

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONArray rankInfo = new JSONArray(new JSONTokener(in));

                if (rankInfo.isEmpty()) {
                    this.rank = "unranked";
                    this.gameMode = "RANKED_SOLO_5x5";
                }
                else {
                    final JSONObject playerData = rankInfo.getJSONObject(0);

                    this.rank = playerData.getString("tier");
                    this.division = playerData.getString("rank");
                    this.leaguePoints = playerData.getInt("leaguePoints");
                    this.wins = playerData.getInt("wins");
                    this.losses = playerData.getInt("losses");
                    this.gameMode = playerData.getString("queueType");

                    this.winRate = round(((float) this.wins / (this.wins + this.losses)) * 100);
                }
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    private HttpURLConnection getHttpURLConnection(String summonerID, String region) throws IOException {
        final String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/";
        }
        else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://euw1.api.riotgames.com/lol/league/v4/entries/by-summoner/";
        }
        else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";
        }
        else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        final String urlComplete = baseURL + summonerID;
        final URL url = new URL(urlComplete);
        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);
        return request;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getRank() {
        return rank;
    }

    public String getDivision() {
        return division;
    }

    public String getGameMode() {
        return gameMode;
    }

    public int getWinRate() {
        return winRate;
    }
}