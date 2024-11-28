package entity;

public class PlayerStatsFactory {

    public PlayerStats createPlayerStats(String playerName, int kills, int deaths, int assists, int totalScore) {
        return new PlayerStats(playerName, kills, deaths, assists, totalScore);
    }
}
