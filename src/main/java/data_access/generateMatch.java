package data_access;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class generateMatch {
    public static JSONObject generateMatch(String matchId, String region, String API_KEY) {
        final String urlComplete = "https://" + region + ".api.riotgames.com/lol/match/v5/matches/" + matchId;
        final URL url = new URL(urlComplete);

        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        return new JSONObject(new JSONTokener(in));
    }
}
