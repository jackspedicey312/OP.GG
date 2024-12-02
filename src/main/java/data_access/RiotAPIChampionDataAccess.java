package data_access;

import entity.champion.Champion;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetches champion data for a summoner from the Riot API.
 */
public class RiotAPIChampionDataAccess {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    /**
     * Fetch the top 5 champions for a summoner.
     *
     * @param puuid  The player's unique identifier.
     * @param region The region of the player (e.g., NA, EU).
     * @return A list of the top 5 Champion entities containing only championId, championLevel, and championPoints.
     * @throws IOException If there's an error in fetching the data.
     */
    public List<Champion> fetchTop5Champions(String puuid, String region) throws IOException {
        final List<Champion> championList = new ArrayList<>();

        final HttpURLConnection request = getHttpURLConnection(puuid, region);
        final int responseCode = request.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONArray championDataArray = new JSONArray(new JSONTokener(in));

                for (int i = 0; i < Math.min(5, championDataArray.length()); i++) {
                    final JSONObject championData = championDataArray.getJSONObject(i);

                    Champion champion = new Champion(

                            championData.getInt("championId"),
                            championData.getInt("championLevel"),
                            championData.getInt("championPoints")
                    );

                    championList.add(champion);
                }
            }
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }

        return championList;
    }

    /**
     * Sets up the HTTP connection for fetching champion data.
     *
     * @param puuid  The player's unique identifier.
     * @param region The player's region.
     * @return An HttpURLConnection object for the API call.
     * @throws IOException If there's an error in the connection setup.
     */
    private HttpURLConnection getHttpURLConnection(String puuid, String region) throws IOException {
        final String baseURL;

        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/";
        } else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/";
        } else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/";
        } else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        final String completeURL = baseURL + puuid;
        final URL url = new URL(completeURL);
        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);
        return request;
    }
}
