package data_access;

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

public class RiotAPIChampionDataAccess {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";
    private String summonerID;
    private String region;

    public RiotAPIChampionDataAccess(String summonerID, String region) {
        this.summonerID = summonerID;
        this.region = region;
    }


    public List<RawChampionData> fetchAllChampions(String summonerID, String region) throws IOException {



        final HttpURLConnection request = getHttpURLConnection();
        final int responseCode = request.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONArray championInfoArray = new JSONArray(new JSONTokener(in));

                for (int i = 0; i < championInfoArray.length(); i++) {
                    JSONObject championData = championInfoArray.getJSONObject(i);

                    rawChampionDataList.add(new RawChampionData(
                            championData.getString("championName"),
                            championData.getInt("championId"),
                            championData.getInt("magicDamageDealt"),
                            championData.getInt("physicalDamageDealt"),
                            championData.getInt("totalDamageDealt"),
                            championData.getInt("trueDamageDealt"),
                            championData.getInt("kills")
                    ));
                }

                return rawChampionDataList;
            }
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    private HttpURLConnection getHttpURLConnection() throws IOException {
        final String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
        } else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
        } else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
        } else {
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





