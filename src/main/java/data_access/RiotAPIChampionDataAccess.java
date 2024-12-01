package data_access;

import entity.Champion.Champion;
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

/***
 * Fetches champion data from the Riot API.
 */
public class RiotAPIChampionDataAccess {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";
    private String summonerID;
    private String region;

    public RiotAPIChampionDataAccess(String summonerID, String region) {
        this.summonerID = summonerID;
        this.region = region;
    }

    public void setSummonerIDAndRegion(String summonerID, String region) {
        this.summonerID = summonerID;
        this.region = region;
    }

    /**
     * Fetch champion data for all champions for the summoner.
     * @return A list of Champion entities containing champion data.
     * @throws IOException If no champion found in data.
     */
    public List<Champion> fetchAllChampions() throws IOException {
        List<Champion> championList = new ArrayList<>();

        final HttpURLConnection request = getHttpURLConnection();
        final int responseCode = request.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONObject matchDetails = new JSONObject(new JSONTokener(in));
                final JSONObject info = matchDetails.getJSONObject("info");
                final JSONArray participants = info.getJSONArray("participants");

                for (int i = 0; i < participants.length(); i++) {
                    JSONObject participant = participants.getJSONObject(i);

                    String championName = participant.getString("championName");
                    int championId = participant.getInt("championId");
                    int magicDamage = participant.getInt("magicDamageDealt");
                    int physicalDamage = participant.getInt("physicalDamageDealt");
                    int totalDamage = participant.getInt("totalDamageDealt");
                    int trueDamage = participant.getInt("trueDamageDealt");
                    int kills = participant.getInt("kills");

                    Champion champion = new Champion(
                            championName,
                            championId,
                            magicDamage,
                            physicalDamage,
                            totalDamage,
                            trueDamage,
                            kills
                    );

                    championList.add(champion);
                }
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }

        return championList;
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
