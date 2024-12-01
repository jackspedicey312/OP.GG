package data_access;

import entity.FunFacts.FunFacts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class RiotAPIFunFactsDataAccess {

    public FunFacts fetchFunFacts(String puuid, String region) throws Exception {
        final RiotAPIMatchDataAccess riotAPIMatchDataAccess = new RiotAPIMatchDataAccess();
        final List<String> matches = riotAPIMatchDataAccess.fetchRecentMatchIds(puuid, region, 100);
        int totalPlaytime = 0;
        int totalWins = 0;
        int totalLosses = 0;
        int totalKills = 0;
        int totalDeaths = 0;
        long oldestGamePlayedUnix = 0;
        int longestGamePlayed = 0;
        long longestGamePlayedDate = 0;
        int totalSurrenders = 0;
        int totalPentakills = 0;
        int totalsurvivedSingleDigitHp = 0;
        int totalSnowballsHit = 0;
        int totalSavedAllies = 0;

        for (int i = 0; i < matches.size(); i++) {

            try {
                JSONObject matchDetail = riotAPIMatchDataAccess.fetchMatchDetails(matches.get(i), region);

                // The json file is split into 2 sections. We want the info section for the stats.
                JSONObject matchInfo = matchDetail.getJSONObject("info");
                JSONObject metaData = matchDetail.getJSONObject("metadata");

                // gameDuration is returned in seconds(int). Will be converted into hours inside the entity file.
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
                int j = getPlayerMatchIndex(puuid, participants);
                playerStats = matchInfo.getJSONArray("participants").getJSONObject(j);
                playerStats2 = playerStats.getJSONObject("challenges");

                if (playerStats.getBoolean("win")) {
                    totalWins += 1;
                } else {
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

            } catch (Exception e) {
                System.err.println("Could not retrieve details for this match: " + matches.get(i) + "->"
                        + e.getMessage());
                continue;
            }
        }
        final FunFacts funFacts = new FunFacts();
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

    public int getPlayerMatchIndex(String puuId, JSONArray participants) {
        for (int j = 0; j < participants.length(); j++) {
            if (puuId.equals(participants.getString(j))) {
                return j;
            }
        }
    }
}
