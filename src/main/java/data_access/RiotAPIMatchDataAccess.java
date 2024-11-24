package data_access;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RiotAPIMatchDataAccess {

    private static final String API_KEY = "RGAPI-26d1c2d7-7907-4cac-b967-46da73c5faa4";

    public List<String> fetchRecentMatchIds(String puuid, String region, int count) throws Exception {
        String baseURL = "https://" + region + ".api.riotgames.com/lol/match/v5/matches/by-puuid/";
        String urlString = baseURL + puuid + "/ids?start=0&count=" + count;
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            JSONArray jsonResponse = new JSONArray(response.toString());
            List<String> matchIds = new ArrayList<>();
            for (int i = 0; i < jsonResponse.length(); i++) {
                matchIds.add(jsonResponse.getString(i));
            }
            return matchIds;
        } else {
            throw new Exception("Failed to fetch match IDs. HTTP Code: " + responseCode);
        }
    }

    public JSONObject fetchMatchDetails(String matchId, String region) throws Exception {
        String urlString = "https://" + region + ".api.riotgames.com/lol/match/v5/matches/" + matchId;
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            return new JSONObject(response.toString());
        } else {
            throw new Exception("Failed to fetch match details. HTTP Code: " + responseCode);
        }
    }
}
