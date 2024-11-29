package entity.Match;

import entity.PlayerStats.PlayerStats;

import java.util.List;

public class MatchFactory {

    public Match createMatch(String matchId, String timestamp, String gameMode, List<PlayerStats> playerStats) {
        return new Match(matchId, timestamp, gameMode, playerStats);    }
}
