package data_access;

import entity.User;
import org.json.JSONObject;
import org.json.JSONTokener;
import use_case.login.LoginUserDataAccessInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RiotAPILoginDataAccess implements LoginUserDataAccessInterface {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    @Override
    public String fetchPUUID(User user) throws IOException {
        String baseURL;

        switch (user.getRegion().toUpperCase()) {
            case "NA":
                baseURL = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
                break;
            case "EU":
                baseURL = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
                break;
            case "ASIA":
                baseURL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
                break;
            default:
                throw new IllegalArgumentException("Unsupported region: " + user.getRegion());
        }

        String urlComplete = baseURL + user.getUsername() + "/" + user.getTagline();
        URL url = new URL(urlComplete);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                JSONObject playerData = new JSONObject(new JSONTokener(in));
                return playerData.getString("puuid");
            }
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }
}
