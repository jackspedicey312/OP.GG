package entity;

import java.util.List;

/**
 * Represents a match retrieved from Riot API.
 */
public class Match {
    private final String matchId;
    private final String timestamp;
    private final String gameMode;

    public Match(String matchId, String timestamp, String gameMode) {
        this.matchId = matchId;
        this.timestamp = timestamp;
        this.gameMode = gameMode;
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
}



