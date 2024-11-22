package data_access;

import entity.Match;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import use_case.match.boundaries.MatchAPIDataAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RiotAPIMatchDataAccess implements MatchAPIDataAccess {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

    @Override
    public List<String> fetchRecentMatchIds(String puuid, int count) throws IOException {
        String url = String.format(
                "https://<region>.api.riotgames.com/lol/match/v5/matches/by-puuid/%s/ids?count=%d",
                puuid, count
        );

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Riot-Token", API_KEY);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                JSONArray matchIdsJson = new JSONArray(new JSONTokener(reader));
                List<String> matchIds = new ArrayList<>();
                for (int i = 0; i < matchIdsJson.length(); i++) {
                    matchIds.add(matchIdsJson.getString(i));
                }
                return matchIds;
            }
        } else {
            throw new IOException("Failed to fetch match IDs. Response code: " + responseCode);
        }
    }

    @Override
    public List<Match> fetchMatchDetails(List<String> matchIds) throws IOException {
        List<Match> matches = new ArrayList<>();

        for (String matchId : matchIds) {
            String url = String.format(
                    "https://<region>.api.riotgames.com/lol/match/v5/matches/%s",
                    matchId
            );

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Riot-Token", API_KEY);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    JSONObject matchJson = new JSONObject(new JSONTokener(reader));
                    String timestamp = matchJson.getString("gameCreation");
                    String participants = matchJson.getJSONArray("participantIdentities").toString();
                    String result = "Win";  // Simplified; parse from match details as needed

                    matches.add(new Match(matchId, timestamp, result, participants));
                }
            } else {
                throw new IOException("Failed to fetch match details for matchId: " + matchId);
            }
        }

        return matches;
    }
}

