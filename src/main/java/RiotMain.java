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
    private String puuid;
    private String username;
    private String tagline;
    private String region;

    public RiotMain(String username, String tagline, String region) {
        this.username = username;
        this.tagline = tagline;
        this.region = region;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter tagline:");
        String tagline = scanner.nextLine();

        System.out.println("Enter your region (NA, ASIA, EU):");
        String region = scanner.nextLine();

        scanner.close();

        try {
            RiotMain riotMain = new RiotMain(username, tagline, region);
            riotMain.generatePUUID();
            System.out.println("Generated PUUID: " + riotMain.getPuuid());

            // Create MatchInfo instance with the RiotMain instance and fetch match data
            MatchInfo matchInfo = new MatchInfo(riotMain);
            matchInfo.displayRecentMatchesAndDetails();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Generates PUUID based on stored username, tagline, and region.
     * @throws IOException if the API call fails.
     * @throws IllegalArgumentException if unsupported region is called.
     */
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public void generatePUUID() throws IOException {
        final String baseURL;
        
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        } 
        else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        } 
        else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        } 
        else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        final String urlComplete = baseURL + username + "/" + tagline;
        final URL url = new URL(urlComplete);

        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONObject playerData = new JSONObject(new JSONTokener(in));
                this.puuid = playerData.getString("puuid");
            }
        } 
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    public String getPuuid() {
        return puuid;
    }

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public String getRegion() {
        return region;
    }
}
