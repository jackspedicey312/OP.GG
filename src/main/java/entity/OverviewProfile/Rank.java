package entity.OverviewProfile;

import javax.swing.*;

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

    public ImageIcon getRankImage() {
        if (rank.equalsIgnoreCase("iron")) {
            return new ImageIcon("images/RankImages/Rank=Bronze.png");
        }
        if (rank.equalsIgnoreCase("bronze")) {
            return new ImageIcon("images/RankImages/Rank=Bronze.png");
        }
        if (rank.equalsIgnoreCase("silver")) {
            return new ImageIcon("images/RankImages/Rank=Silver.png");
        }
        if (rank.equalsIgnoreCase("gold")) {
            return new ImageIcon("images/RankImages/Rank=Gold.png");
        }
        if (rank.equalsIgnoreCase("platinum")) {
            return new ImageIcon("images/RankImages/Rank=Platinum.png");
        }
        if (rank.equalsIgnoreCase("emerald")) {
            return new ImageIcon("images/RankImages/Rank=Emerald.png");
        }
        if (rank.equalsIgnoreCase("diamond")) {
            return new ImageIcon("images/RankImages/Rank=Diamond.png");
        }
        if (rank.equalsIgnoreCase("Master")) {
            return new ImageIcon("images/RankImages/Rank=Master.png");
        }
        if (rank.equalsIgnoreCase("Grandmaster")) {
            return new ImageIcon("images/RankImages/Rank=Grandmaster.png");
        }
        if (rank.equalsIgnoreCase("challenger")) {
            return new ImageIcon("images/RankImages/Rank=Challenger.png");
        }
    }
}
