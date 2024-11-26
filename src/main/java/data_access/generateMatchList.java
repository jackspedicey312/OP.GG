package data_access;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class generateMatchList {

    public static JSONArray generateMatchList(String puuid, String region, String API_KEY) {
        String urlComplete = "https://" + region + ".api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=5";
        URL url = new URL(urlComplete);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        return new JSONArray(new JSONTokener(in));
    }
}
