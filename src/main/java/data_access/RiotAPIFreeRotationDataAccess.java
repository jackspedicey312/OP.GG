package data_access;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RiotAPIFreeRotationDataAccess {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    public JSONArray generateCurrentFreeRotation() throws IOException {
        final HttpURLConnection request = getHttpURLConnection();

        final int responseCode = request.getResponseCode();

        System.out.println("Generating free champion rotation");

        if (responseCode == HttpURLConnection.HTTP_OK) {
            final JSONArray freeChampions;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONObject playerData = new JSONObject(new JSONTokener(in));
                return playerData.getJSONArray("freeChampionIds");
            }
        }
        return null;
    }

    public ArrayList<String> getFreeChampionsNames() throws IOException {
        final JSONArray freeChampions = generateCurrentFreeRotation();
        final ArrayList<String> freeChampionsList = new ArrayList<>();
        for (int i = 0; i < freeChampions.length(); i++) {
            final int iD = freeChampions.getInt(i);
            freeChampionsList.add(getChampionName(iD));
        }
        return freeChampionsList;
    }

    public ArrayList<ImageIcon> getFreeChampionsIcons() throws IOException {
        final JSONArray freeChampions = generateCurrentFreeRotation();
        final ArrayList<ImageIcon> freeChampionsIcons = new ArrayList<>();
        for (int i = 0; i < freeChampions.length(); i++) {
            final int iD = freeChampions.getInt(i);
            freeChampionsIcons.add(getChampionIcon(iD));
        }
        return freeChampionsIcons;
    }

    public String getChampionName(int championId) throws IOException {
        final URL url = new URL("https://ddragon.leagueoflegends.com/cdn/14.22.1/data/en_US/champion.json");
        final JSONObject data = getJsonObject(url);

        for (String key : data.keySet()) {
            JSONObject champion = data.getJSONObject(key);
            int characterId = champion.getInt("key");

            if (characterId == championId) {
                return champion.getString("id");
            }
        }
        return null;
    }

    private static JSONObject getJsonObject(URL url) throws IOException {
        final HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();

        final BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        final StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        JSONObject championDatabase = new JSONObject(response.toString());
        JSONObject data = championDatabase.getJSONObject("data");
        return data;
    }


    public ImageIcon getChampionIcon(int championId) throws IOException {
        final String champName = getChampionName(championId);
        if (champName != null) {
            final String url = "https://ddragon.canisback.com/img/champion/tiles/" + champName + "_0.jpg";
            final URL completeUrl = new URL(url);

            try {
                final BufferedImage img = ImageIO.read(completeUrl);
                return new ImageIcon(img);
            }
            catch (IOException e) {
                System.err.println("Error fetching icon for champion: " + e.getMessage());
                return null;
            }
        }
        return null;

    }

    private HttpURLConnection getHttpURLConnection () throws IOException {
        final String baseURL = "https://na1.api.riotgames.com/lol/platform/v3/champion-rotations";

        final URL url = new URL(baseURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);

        return request;
    }


}