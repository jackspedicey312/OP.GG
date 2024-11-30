package entity.Match;

import entity.PlayerStats.PlayerStats;

import javax.swing.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Represents a match retrieved from Riot API.
 */
public class Match {
    private final ImageIcon chmapionIcon;
    private final int kills;
    private final int deaths;
    private final int assissts;
    private final int gameDuration;
    private final String gameMode;
    private final String date;

    public Match(String matchId, String timestamp, String gameMode, List<PlayerStats> playerStats) {
        this.matchId = matchId;
        this.timestamp = timestamp;
        this.gameMode = gameMode;
        this.playerStats = playerStats;
    }

    public static String unixConverter(long unixCode) {
        Instant instant = Instant.ofEpochSecond(unixCode);

        // Define a formatter for a readable date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
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
