package entity;

public class Rank {
    private String gameMode;
    private String rank;
    private String division;
    private int leaguePoints;
    private int wins;
    private int losses;
    private int winRate;

    public Rank(String gameMode, String rank, String division, int leaguePoints, int wins,
                int losses, int winRate) {
        this.gameMode = gameMode;
        this.rank = rank;
        this.division = division;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.winRate = winRate;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getRank() {
        return rank;
    }

    public String getDivision() {
        return division;
    }

    public String getGameMode() {
        return gameMode;
    }

    public int getWinRate() {
        return winRate;
    }
}
