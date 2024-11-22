import data_access.RankMain;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RankMainTest {
    @Test
    public void testRankMain() throws IOException {

        String summonerId = "wIN_kwz0GoArhLlUuZGoXAl6nrG2vvfXIlsXlFRupemnAM8-";
        String region = "NA";

        String queueType = "RANKED_SOLO_5x5";
        String tier = "SILVER";
        String division = "I";
        int leaguePoints = 87;
        int wins = 3;
        int losses = 2;
        int winRate = 60;

        RankMain rankMain = new RankMain(summonerId, region);
        rankMain.generateRank();

        assertEquals(queueType, rankMain.getGameMode());
        assertEquals(tier, rankMain.getRank());
        assertEquals(division, rankMain.getDivision());
        assertEquals(leaguePoints, rankMain.getLeaguePoints());
        assertEquals(wins, rankMain.getWins());
        assertEquals(losses, rankMain.getLosses());
        assertEquals(winRate, rankMain.getWinRate());
    }

    @org.junit.Test
    public void testRankMain2() throws IOException {
        String summonerID = "nItPoQnTxCT4hMMqcmUyqNcjKdDHRlPEEmj5CLiK7TWRWUAw";
        String region = "NA";
        String tier = "unranked";
        String queueType = "RANKED_SOLO_5x5";

        RankMain rankMain = new RankMain(summonerID, region);
        rankMain.generateRank();

        assertEquals(tier, rankMain.getRank());
        assertEquals(queueType, rankMain.getGameMode());
    }
}
