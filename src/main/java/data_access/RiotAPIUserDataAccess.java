package data_access;

import entity.User;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RiotAPIUserDataAccess {

    private static final String API_KEY = "RGAPI-26d1c2d7-7907-4cac-b967-46da73c5faa4";

    public String fetchPUUID(String username, String tagline, String region) throws Exception {
        String baseURL;
        switch (region.toLowerCase()) {
            case "na":
                baseURL = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
                break;
            case "eu":
                baseURL = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
                break;
            case "asia":
                baseURL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
                break;
            default:
                throw new IllegalArgumentException("Invalid region: " + region);
        }

        String urlString = baseURL + username + "/" + tagline;
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

            JSONObject jsonResponse = new JSONObject(response.toString());
            return jsonResponse.getString("puuid");
        } else {
            throw new Exception("Failed to fetch PUUID. HTTP Code: " + responseCode);
        }
    }
}
