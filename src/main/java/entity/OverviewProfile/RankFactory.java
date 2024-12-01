package entity.OverviewProfile;

public class RankFactory {

    public Rank createRank(String gameMode, String rank, String division, int leaguePoints, int wins,
                      int losses, int winRate) {
        return new Rank(gameMode, rank, division, leaguePoints, wins, losses, winRate);
    }
}
