package data_access;

import org.jetbrains.annotations.NotNull;
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

public class RiotAPIProfileDataAccess {
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";
    private final String puuid;
    private final String region;
    private String summonerID;
    private String accountID;
    private int summonerLevel;
    private int iconID;
    private ImageIcon iconPng;

    public ProfileMain(String puuid, String region) {
        this.puuid = puuid;
        this.region = region;
    }

    public void generateProfileData() throws IOException {
        final HttpURLConnection request = getHttpURLConnection();

        final int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
                final JSONObject playerData = new JSONObject(new JSONTokener(in));

                this.summonerID = playerData.getString("id");
                this.summonerLevel = playerData.getInt("summonerLevel");
                this.iconID = playerData.getInt("profileIconId");
                this.accountID = playerData.getString("accountId");
            }
        }
        else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    @NotNull
    private HttpURLConnection getHttpURLConnection() throws IOException {
        final String baseURL;
        if (region.equalsIgnoreCase("NA")) {
            baseURL = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
        }
        else if (region.equalsIgnoreCase("EU")) {
            baseURL = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
        }
        else if (region.equalsIgnoreCase("ASIA")) {
            baseURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";
        }
        else {
            throw new IllegalArgumentException("Unsupported region: " + region);
        }

        String urlComplete = baseURL + puuid;
        URL url = new URL(urlComplete);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("X-Riot-Token", API_KEY);
        return request;
    }

    public String getSummonerID() {
        return summonerID;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public int getIconID() {
        return iconID;
    }

    /**
     @throws IOException if icon png cannot be found with the given iconID.
     Returns the icon png with the given iconID.
     */

    public ImageIcon getIconPng() throws IOException {
        final String iconId2 = Integer.toString(this.iconID);
        final String pngURL = "https://ddragon.leagueoflegends.com/cdn/14.22.1/img/profileicon/"
                + iconId2 + ".png";

        try {
            final URL url = new URL(pngURL);
            final BufferedImage img = ImageIO.read(url);
            this.iconPng = new ImageIcon(img);
            return iconPng;
        }

        catch (IOException e) {
            System.err.println("Error fetching the icon: " + e.getMessage());
            return null;
        }
    }

    public String getAccountID() {
        return accountID;
    }
}