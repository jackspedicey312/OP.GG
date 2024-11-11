import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MatchInfo {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";
    public RiotMain riotMain;

    // Constructor that accepts a RiotMain instance to access PUUID and region
    public MatchInfo(RiotMain riotMain) {
        this.riotMain = riotMain;
    }

    public void displayRecentMatchesAndDetails() {
        try {
            String puuid = riotMain.getPuuid();
            String region = riotMain.getRegion();

            if (puuid == null) {
                System.out.println("PUUID not generated.");
                return;
            }

            // Fetch recent matches
            JSONArray recentMatches = getRecentMatches(puuid, region);
            System.out.println("Recent Matches: " + recentMatches);

            // If there are matches, fetch details for the first one
            if (recentMatches.length() > 0) {
                String matchId = recentMatches.getString(0);
                JSONObject matchDetails = getMatchDetails(matchId, region);
                System.out.println("Match Details for match ID " + matchId + ": " + matchDetails.toString(2));
            }
        } catch (IOException e) {
            System.err.println("Error fetching match data: " + e.getMessage());
        }
    }

    public JSONArray getRecentMatches(String puuid, String region) throws IOException {
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

    public JSONObject getMatchDetails(String matchId, String region) throws IOException {
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

