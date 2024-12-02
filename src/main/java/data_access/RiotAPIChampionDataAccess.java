package data_access;

import entity.champion.Champion;
import entity.champion.ChampionFactory;
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
 * Fetches champion data for a summoner from the Riot API.
 */
public class RiotAPIChampionDataAccess {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    /**
     * Fetch all champion data for a summoner.
     *
     * @param puuid  The player's unique identifier.
     * @param region The region of the player (e.g., NA, EU).
     * @return A list of Champion entities.
     * @throws IOException If there's an error in fetching the data.
     */
    public List<Champion> fetchAllChampions(String puuid, String region) throws IOException {
        final List<Champion> championList = new ArrayList<>();

        final HttpURLConnection request = getHttpURLConnection(puuid, region);
        final int responseCode = request.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONArray championDataArray = new JSONArray(new JSONTokener(in));

                for (int i = 0; i < championDataArray.length(); i++) {
                    final JSONObject championData = championDataArray.getJSONObject(i);

                    ChampionFactory championFactory = new ChampionFactory();
                    Champion champion = championFactory.createChampion(
                            getChampionName(championData),
                            getChampionId(championData),
                            getMagicDamage(championData),
                            getPhysicalDamage(championData),
                            getTotalDamage(championData),
                            getTrueDamage(championData),
                            getKills(championData),
                            getMasteryPoints(championData)
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

    /**
     * Gets the champion name based on champion data.
     */
    public String getChampionName(JSONObject championData) throws IOException {
        int championId = championData.getInt("championId");
        final URL url = new URL("https://ddragon.leagueoflegends.com/cdn/14.22.1/data/en_US/champion.json");
        final JSONObject championDatabase = getJsonObject(url);

        for (String key : championDatabase.keySet()) {
            JSONObject champion = championDatabase.getJSONObject(key);
            if (champion.getInt("key") == championId) {
                return champion.getString("id");
            }
        }
        return "Unknown";
    }

    /**
     * Gets the champion ID from champion data.
     */
    public int getChampionId(JSONObject championData) {
        return championData.getInt("championId");
    }


    /**
     * Gets the magic damage dealt from champion data.
     */
    public int getMagicDamage(JSONObject championData) {
        return championData.optInt("magicDamageDealt", 0);
    }

    /**
     * Gets the physical damage dealt from champion data.
     */
    public int getPhysicalDamage(JSONObject championData) {
        return championData.optInt("physicalDamageDealt", 0);
    }

    /**
     * Gets the total damage dealt from champion data.
     */
    public int getTotalDamage(JSONObject championData) {
        return championData.optInt("totalDamageDealt", 0);
    }

    /**
     * Gets the true damage dealt from champion data.
     */
    public int getTrueDamage(JSONObject championData) {
        return championData.optInt("trueDamageDealt", 0);
    }

    /**
     * Gets the number of kills from champion data.
     */
    public int getKills(JSONObject championData) {
        return championData.optInt("kills", 0);
    }

    /**
     * Gets the mastery points from champion data.
     */
    public int getMasteryPoints(JSONObject championData) {
        return championData.optInt("championPoints", 0);
    }


    /**
     * Retrieves the JSON object for champion metadata.
     *
     * @param url The URL to fetch the JSON data.
     * @return A JSONObject containing champion metadata.
     * @throws IOException If there's an error fetching the data.
     */
    private JSONObject getJsonObject(URL url) throws IOException {
        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            final StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return new JSONObject(response.toString()).getJSONObject("data");
        }
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
