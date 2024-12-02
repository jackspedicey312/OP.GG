package data_access;

import entity.OverviewProfile.ProfileOverview;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RiotAPIProfileDataAccess {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    // PUUID AND REGION NEEDED TO CALL API
    public ProfileOverview generateProfileData(String puuid, String region) throws IOException {

        final HttpURLConnection request = getHttpURLConnection(puuid, region);

        // This is for getting the username and tagline.
        final HttpURLConnection request2 = getHttpURLConnection2(puuid, region);

        final int responseCode2 = request2.getResponseCode();
        final int responseCode = request.getResponseCode();

        System.out.println("Generating profile Data");

        if (responseCode == HttpURLConnection.HTTP_OK && responseCode2 == HttpURLConnection.HTTP_OK)  {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONObject playerData = new JSONObject(new JSONTokener(in));

                String summonerID = playerData.getString("id");
                int summonerLevel = playerData.getInt("summonerLevel");
                int iconID = playerData.getInt("profileIconId");

                BufferedReader in2 = new BufferedReader(new InputStreamReader(request2.getInputStream()));
                final JSONObject playerData2 = new JSONObject(new JSONTokener(in2));

                String username = playerData2.getString("gameName");
                String tag = playerData2.getString("tagLine");

                ProfileOverview profile = new ProfileOverview(username, tag, summonerID, summonerLevel, iconID);
                return profile;
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    @NotNull
    private HttpURLConnection getHttpURLConnection(String puuid, String region) throws IOException {
        final String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
        }
        else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
        }
        else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
        }
        else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        String urlComplete = baseURL + puuid;
        URL url = new URL(urlComplete);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        return request;
    }

    private HttpURLConnection getHttpURLConnection2(String puuid, String region) throws IOException {
        final String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-puuid/";
        }
        else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-puuid/";
        }
        else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-puuid/";
        }
        else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        String urlComplete = baseURL + puuid;
        URL url = new URL(urlComplete);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        return request;
    }

}
