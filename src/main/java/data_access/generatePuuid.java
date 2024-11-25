package data_access;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class generatePuuid {
    public static String generatePuuid(String username, String tagline, String region, String API_KEY) throws IOException {
        final String urlComplete = "https://" + region + ".api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + username + "/" + tagline;
        final URL url = new URL(urlComplete);

        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                return new JSONObject(new JSONTokener(in)).getString("puuid");
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }
}
