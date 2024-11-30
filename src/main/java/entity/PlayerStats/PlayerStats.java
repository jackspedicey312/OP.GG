package entity.PlayerStats;

/**
 * Represents a player's performance in a match.
 */
public class PlayerStats {
    private final String playerName;
    private final int kills;
    private final int deaths;
    private final int assists;
    private final int totalScore;

    public PlayerStats(String playerName, int kills, int deaths, int assists, int totalScore) {
        this.playerName = playerName;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.totalScore = totalScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "playerName='" + playerName + '\'' +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", totalScore=" + totalScore +
                '}';
    }
}
