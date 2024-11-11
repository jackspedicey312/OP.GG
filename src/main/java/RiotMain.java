import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RiotMain {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter tagline:");
        String tagline = scanner.nextLine();

        System.out.println("Enter your region (NA, ASIA, EU):");
        String region = scanner.nextLine();

        scanner.close();

        JSONObject puuidData = generatePUUID(username, tagline, region);
        String puuid = puuidData.getString("puuid");
        System.out.println("PUUID: " + puuid);

        // Fetch and display recent match IDs
        JSONArray matchIds = getRecentMatches(puuid, region);
        System.out.println("Recent Matches: " + matchIds);

        // Fetch details of the first match (if available)
        if (matchIds.length() > 0) {
            String matchId = matchIds.getString(0);
            JSONObject matchDetails = getMatchDetails(matchId, region);
            System.out.println("Match Details: " + matchDetails);
        }
    }

    /**
     * Generates PUUID data with the username and tag.
     */
    public static JSONObject generatePUUID(String username, String tagline, String region) throws IOException {
        String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        } else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        } else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        } else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        String urlComplete = baseURL + username + "/" + tagline;
        URL url = new URL(urlComplete);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                return new JSONObject(new JSONTokener(in));
            }
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    /**
     * Retrieves recent match IDs for a player based on their PUUID.
     */
    public static JSONArray getRecentMatches(String puuid, String region) throws IOException {
        String baseURL;
        if (region.equalsIgnoreCase("NA") || region.equalsIgnoreCase("LATAM") || region.equalsIgnoreCase("BR")) {
            baseURL = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
        } else if (region.equalsIgnoreCase("EU") || region.equalsIgnoreCase("EUNE") || region.equalsIgnoreCase("EUW") || region.equalsIgnoreCase("TR") || region.equalsIgnoreCase("RU")) {
            baseURL = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";
        } else if (region.equalsIgnoreCase("ASIA") || region.equalsIgnoreCase("KR") || region.equalsIgnoreCase("JP")) {
            baseURL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";
        } else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        String urlComplete = baseURL + puuid + "/ids?start=0&count=5";
        URL url = new URL(urlComplete);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                return new JSONArray(new JSONTokener(in));
            }
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    /**
     * Retrieves details for a specific match using the match ID.
     */
    public static JSONObject getMatchDetails(String matchId, String region) throws IOException {
        String baseURL;
        if (region.equalsIgnoreCase("NA") || region.equalsIgnoreCase("LATAM") || region.equalsIgnoreCase("BR")) {
            baseURL = "https://americas.api.riotgames.com/lol/match/v5/matches/";
        } else if (region.equalsIgnoreCase("EU") || region.equalsIgnoreCase("EUNE") || region.equalsIgnoreCase("EUW") || region.equalsIgnoreCase("TR") || region.equalsIgnoreCase("RU")) {
            baseURL = "https://europe.api.riotgames.com/lol/match/v5/matches/";
        } else if (region.equalsIgnoreCase("ASIA") || region.equalsIgnoreCase("KR") || region.equalsIgnoreCase("JP")) {
            baseURL = "https://asia.api.riotgames.com/lol/match/v5/matches/";
        } else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        String urlComplete = baseURL + matchId;
        URL url = new URL(urlComplete);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                return new JSONObject(new JSONTokener(in));
            }
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }
}
