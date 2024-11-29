package data_access;

import entity.FunFacts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class RiotAPIFunFactsDataAccess {
    private int totalPlaytime;
    private int totalWins;
    private int totalLosses;
    private int totalKills;
    private int totalDeaths;
    private long oldestGamePlayedUnix;
    private int longestGamePlayed;
    private long longestGamePlayedDate;
    private int totalSurrenders;
    private int totalPentakills;
    private int totalsurvivedSingleDigitHp;
    private int totalSnowballsHit;
    private int totalSavedAllies;
    private final FunFacts funFacts = new FunFacts();

    public FunFacts fetchFunFacts (String puuid, String region) throws Exception {
        final RiotAPIMatchDataAccess riotAPIMatchDataAccess = new RiotAPIMatchDataAccess();
        final List<String> matches = riotAPIMatchDataAccess.fetchRecentMatchIds(puuid, region, 100);

        for (int i = 0; i < matches.size(); i++) {

            try {
                JSONObject matchDetail = riotAPIMatchDataAccess.fetchMatchDetails(matches.get(i), region);

                // The json file is split into 2 sections. We want the info section mainly.
                JSONObject matchInfo = matchDetail.getJSONObject("info");
                JSONObject metaData = matchDetail.getJSONObject("metadata");

                // gameDuration is returned in seconds(int). Will be converted into hours later.
                int gameDuration = matchInfo.getInt("gameDuration");

                totalPlaytime += gameDuration;

                // longestGamePlayed keeps track of the longest game played in the match history
                if (gameDuration > longestGamePlayed) {
                    longestGamePlayed = gameDuration;
                    longestGamePlayedDate = matchInfo.getLong("gameEndTimestamp");
                }

                // This extracts the player's stats for that EXACT match
                JSONObject playerStats = null;
                JSONObject playerStats2 = null;
                JSONArray participants = metaData.getJSONArray("participants");
                for (int j = 0; j < participants.length(); j++) {
                    String player = participants.getString(j);
                    if (puuid.equals(player)) {
                        playerStats = matchInfo.getJSONArray("participants").getJSONObject(j);
                        playerStats2 = playerStats.getJSONObject("challenges");
                        break;
                    }
                    else {
                        continue;
                    }
                }

                if (playerStats.getBoolean("win")) {
                    totalWins += 1;
                }
                else {
                    totalLosses += 1;
                }

                if (playerStats.getBoolean("gameEndedInSurrender")) {
                    totalSurrenders += 1;
                }

                totalKills += playerStats.getInt("kills");
                totalDeaths += playerStats.getInt("deaths");
                totalPentakills += playerStats.getInt("pentaKills");
                totalsurvivedSingleDigitHp += playerStats2.getInt("survivedSingleDigitHpCount");
                totalSnowballsHit += playerStats2.getInt("snowballsHit");
                totalSavedAllies += playerStats2.getInt("saveAllyFromDeath");

                // oldestGamePlayed is the date of the very last game in the match history. IT'S IN UNIX FORM!!
                oldestGamePlayedUnix = matchInfo.getLong("gameEndTimestamp");

                funFacts.setLongestGamePlayedDate(longestGamePlayedDate);
                funFacts.setLongestGamePlayed(longestGamePlayed);
                funFacts.setTotalDeaths(totalDeaths);
                funFacts.setTotalKills(totalKills);
                funFacts.setTotalPlaytime(totalPlaytime);
                funFacts.setTotalWins(totalWins);
                funFacts.setTotalLosses(totalLosses);
                funFacts.setTotalSurvivedSingleDigitHp(totalsurvivedSingleDigitHp);
                funFacts.setTotalSurrenders(totalSurrenders);
                funFacts.setTotalPentakills(totalPentakills);
                funFacts.setTotalSnowballsHit(totalSnowballsHit);
                funFacts.setOldestGamePlayedUnix(oldestGamePlayedUnix);
                funFacts.setTotalSavedAllies(totalSavedAllies);

                return funFacts;

            }
            catch (Exception e) {
                System.err.println("Could not retrieve details for this match: " + matches.get(i) + "->"
                        + e.getMessage());
                continue;
            }
        }
    }

}
