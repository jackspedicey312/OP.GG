package entity.OverviewProfile;

import javax.swing.ImageIcon;

public class Rank {
    private String gameMode;
    private String rank;
    private String division;
    private int leaguePoints;
    private int wins;
    private int losses;
    private int winRate;
    private ImageIcon rankIcon;

    public Rank(String gameMode, String rank, String division, int leaguePoints, int wins,
                int losses, int winRate) {

        this.gameMode = gameMode;
        this.rank = rank;
        this.division = division;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.winRate = winRate;
        this.rankIcon = getRankImage();
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

    public ImageIcon getRankIcon() {
        return rankIcon;
    }

    public ImageIcon getRankImage() {
        if (rank.equalsIgnoreCase("Iron")) {
            return new ImageIcon("images/Rank=Bronze.png");
        }
        if (rank.equalsIgnoreCase("Bronze")) {
            return new ImageIcon("images/Rank=Bronze.png");
        }
        if (rank.equalsIgnoreCase("Silver")) {
            return new ImageIcon("images/Rank=Silver.png");
        }
        if (rank.equalsIgnoreCase("Gold")) {
            return new ImageIcon("images/Rank=Gold.png");
        }
        if (rank.equalsIgnoreCase("Platinum")) {
            return new ImageIcon("images/Rank=Platinum.png");
        }
        if (rank.equalsIgnoreCase("Emerald")) {
            return new ImageIcon("images/Rank=Emerald.png");
        }
        if (rank.equalsIgnoreCase("Diamond")) {
            return new ImageIcon("images/Rank=Diamond.png");
        }
        if (rank.equalsIgnoreCase("Master")) {
            return new ImageIcon("images/Rank=Master.png");
        }
        if (rank.equalsIgnoreCase("Grandmaster")) {
            return new ImageIcon("images/Rank=Grandmaster.png");
        }
        if (rank.equalsIgnoreCase("Challenger")) {
            return new ImageIcon("images/Rank=Challenger.png");
        }
        return new ImageIcon();
    }
}
