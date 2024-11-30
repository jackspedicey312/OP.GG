package data_access;

import entity.Rank;
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


    public Rank generateRank(String summonerID, String region) throws IOException {
        final HttpURLConnection request = getHttpURLConnection(summonerID, region);
        String rank;
        String division = "1";
        int leaguePoints = 0;
        int wins = 0;
        int losses = 0;
        String gameMode = "GameMode";
        int winRate = 0;

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONArray rankInfo = new JSONArray(new JSONTokener(in));

                if (rankInfo.isEmpty()) {
                    rank = "unranked";
                    gameMode = "RANKED_SOLO_5x5";
                }
                else {
                    final JSONObject playerData = rankInfo.getJSONObject(0);

                    rank = playerData.getString("tier");
                    division = playerData.getString("rank");
                    leaguePoints = playerData.getInt("leaguePoints");
                    wins = playerData.getInt("wins");
                    losses = playerData.getInt("losses");
                    gameMode = playerData.getString("queueType");

                    winRate = round(((float) wins / (wins + losses)) * 100);
                }
            }
        }

        else {
            throw new IOException("HTTP error code: " + responseCode);
        }

        return new Rank(gameMode, rank, division, leaguePoints, wins, losses, winRate);
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

}