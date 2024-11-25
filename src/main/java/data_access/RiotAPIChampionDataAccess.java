package data_access;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.Math.round;

public class RiotAPIChampionDataAccess {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";
    private String summonerID;
    private String region;

    private String championName;
    private int championID;
    private int magicDamage;
    private int physicalDamage;
    private int totalDamage;
    private int kills;
    private int trueDamage;
    private int masteryPoints;

    public Champion(String summonerID, String region) {
        this.summonerID = summonerID;
        this.region = region;
    }

    public void generateChampionData() throws IOException {
        final HttpURLConnection request = getHttpURLConnection();

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONArray championInfo = new JSONArray(new JSONTokener(in));

                if (championInfo.isEmpty()) {
                    System.out.println("No champions found.");
                }
                else {
                    JSONObject playerData = championInfo.getJSONObject(0);

                    this.championName = playerData.getString("championName");
                    this.championID = playerData.getInt("championId");
                    this.magicDamage = playerData.getInt("magicDamageDealt");
                    this.physicalDamage = playerData.getInt("physicalDamageDealt");
                    this.totalDamage = playerData.getInt("totalDamageDealt");
                    this.trueDamage = playerData.getInt("trueDamageDealt");
                    this.kills = playerData.getInt("kills");

                    this.masteryPoints = calculateMasteryPoints(
                            totalDamage, magicDamage, physicalDamage, trueDamage, kills
                    );
                }
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    private HttpURLConnection getHttpURLConnection() throws IOException {
        final String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
        }
        else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
        }
        else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
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

    private int calculateMasteryPoints(int totalDamage, int magicDamage, int physicalDamage, int trueDamage, int kills) {
        final int totalDamageMax = 100000;
        final int magicDamageMax = 50000;
        final int physicalDamageMax = 90000;
        final int trueDamageMax = 2000;
        final int killsMax = 30;

        int normTotalDamage = normalize(totalDamage, 0, totalDamageMax);
        int normMagicDamage = normalize(magicDamage, 0, magicDamageMax);
        int normPhysicalDamage = normalize(physicalDamage, 0, physicalDamageMax);
        int normTrueDamage = normalize(trueDamage, 0, trueDamageMax);
        int normKills = normalize(kills, 0, killsMax);

        return normTotalDamage + normMagicDamage + normPhysicalDamage + normTrueDamage + normKills;
    }

    private int normalize(int value, int min, int max) {
        return (int) (((double) (value - min) / (max - min)) * 1000);
    }

    public String getChampionName() {
        return championName;
    }

    public int getChampionID() {
        return championID;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public int getKills() {
        return kills;
    }

    public int getTrueDamage() {
        return trueDamage;
    }

    public int getMasteryPoints() {
        return masteryPoints;
    }
}