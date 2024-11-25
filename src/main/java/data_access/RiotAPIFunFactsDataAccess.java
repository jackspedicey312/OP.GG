package data_access;

import entity.PlayerStats;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RiotAPIFunFactsDataAccess {

    private float totalPlaytime;
    private float totalKills;
    private float totalDeaths;


    public ArrayList<String> fetchFunFacts (String puuid, String region) throws Exception {
        RiotAPIMatchDataAccess riotAPIMatchDataAccess = new RiotAPIMatchDataAccess();
        final List<String> matches = riotAPIMatchDataAccess.fetchRecentMatchIds(puuid, region, 10);

        for (int i = 0 ;i < matches.size(); i++) {
            JSONObject matchDetail = riotAPIMatchDataAccess.fetchMatchDetails(matches.get(i), region);
            totalPlaytime += Float.parseFloat(matchDetail.getString("timestamp"));
            totalKills += Float.parseFloat(matchDetail.getString("kills"));
            totalDeaths += Float.parseFloat(matchDetail.getString("deaths"));
        }
        // PLACEHOLDER STILL BEING WORKED ON
        return null;
    }

}
