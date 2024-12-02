package data_access;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles Riot API requests related to match data.
 */
public class RiotAPIMatchDataAccess {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    /**
     * Fetches recent match IDs for a user.
     *
     * @param puuid  The user's PUUID.
     * @param region The user's region.
     * @param count  The number of matches to fetch.
     * @return A list of recent match IDs.
     * @throws Exception If the API call fails.
     */
    public List<String> getRecentMatchIds(String puuid, String region, int count) throws Exception {
        String baseURL;
        switch (region.toLowerCase()) {
            case "na":
            case "latam":
            case "br":
                baseURL = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
                break;
            case "euw":
            case "eune":
            case "tr":
            case "ru":
                baseURL = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";
                break;
            case "kr":
            case "jp":
            case "oce":
            case "sea":
                baseURL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";
                break;
            default:
                throw new IllegalArgumentException("Invalid region: " + region);
        }

        String urlString = baseURL + puuid + "/ids?start=0&count=" + count;
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println("Match being generated");
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
            throw new Exception("Failed to fetch match IDs. HTTP Code: " + responseCode +
                    "\nResponse Message: " + connection.getResponseMessage() +
                    "\nURL: " + urlString);
        }
    }



    /**
     * Fetches detailed information for a specific match.
     *
     * @param matchId The match ID.
     * @param region  The region where the match was played.
     * @return A JSONObject containing match details.
     * @throws Exception If the API call fails.
     */
    public JSONObject getMatchDetails(String matchId, String region) throws Exception {
        String baseURL = getRegionBaseURL(region);
        String urlString = baseURL + matchId;
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
            throw new Exception("Failed to fetch match details. HTTP Code: " + responseCode +
                    "\nResponse Message: " + connection.getResponseMessage() +
                    "\nURL: " + urlString);
        }
    }

    /**
     * Maps the user region to the Riot API's shard group.
     *
     * @param region The user's region (e.g., "NA", "EUW").
     * @return The base URL for the match API.
     */
    private String getRegionBaseURL(String region) {
        switch (region.toLowerCase()) {
            case "na":
            case "latam":
            case "br":
                return "https://americas.api.riotgames.com/lol/match/v5/matches/";
            case "euw":
            case "eune":
            case "tr":
            case "ru":
                return "https://europe.api.riotgames.com/lol/match/v5/matches/";
            case "kr":
            case "jp":
            case "oce":
            case "sea":
                return "https://asia.api.riotgames.com/lol/match/v5/matches/";
            default:
                throw new IllegalArgumentException("Invalid region: " + region);
        }
    }
}
