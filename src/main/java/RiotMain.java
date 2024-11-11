import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * The main class for the op.gg client, handles user input for username and tag.
 */

public class RiotMain {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String username = scanner.nextLine();

        System.out.println("Enter tagline");
        String tagline = scanner.nextLine();

        System.out.println("Enter your region: NA, ASIA, EU");
        String region = scanner.nextLine();

        scanner.close();

        final JSONObject puuidData = generatePUUID(username, tagline, region);
        System.out.println(puuidData);
        final String puuid = puuidData.getString("puuid");
        System.out.println(puuid);
    }

    /**
     * Generates PUUID data with the username and tag.
     * @throws IOException error code is created if api fails to generate given input
     * @param username the username of the player.
     * @param tagline the tagline of the player.
     * @param region the region of the player.
     */

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static JSONObject generatePUUID(String username, String tagline, String region) throws IOException {

        String baseURL = null;
        if (region.toUpperCase().equals("NA")) {
            baseURL = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        }
        else if (region.toUpperCase().equals("EU")) {
            baseURL = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        }
        else if (region.toUpperCase().equals("ASIA")) {
            baseURL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
        }
        final String urlComplete = baseURL + username + "/" + tagline;
        final URL url = new URL(urlComplete);

        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {

            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                JSONObject playerData = new JSONObject(new JSONTokener(in));
                return playerData;
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }
}
