package entity;

import java.util.List;

/**
 * Represents a match retrieved from Riot API.
 */
public class Match {
    private final String matchId;
    private final String timestamp;
    private final String gameMode;
    private final List<PlayerStats> playerStats;

    public Match(String matchId, String timestamp, String gameMode, List<PlayerStats> playerStats) {
        this.matchId = matchId;
        this.timestamp = timestamp;
        this.gameMode = gameMode;
        this.playerStats = playerStats;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getGameMode() {
        return gameMode;
    }

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId='" + matchId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", playerStats=" + playerStats +
                '}';
    }
}
