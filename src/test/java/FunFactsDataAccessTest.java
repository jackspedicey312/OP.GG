import data_access.RiotAPIFunFactsDataAccess;
import entity.FunFacts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FunFactsDataAccessTest {

    // THESE ARE PLACEHOLDER NUMBERS, THERE IS NO CORRECT VALUE SINCE IT DEPENDS ON THE PLAYER
    // THIS IS JUST TO SEE THE TERMINAL VALUE IT RETURNS

    @Test
    public void testFunFactsDataAccess() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(111, funFactsDataAccess2.getTotalPlaytime());

    }
    @Test
    public void testFunFactsDataAccess2() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(242, funFactsDataAccess2.getLongestGamePlayed());

    }
    @Test
    public void testFunFactsDataAccess3() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(123, funFactsDataAccess2.getoldestGamePlayedUnix());

    }
    @Test
    public void testFunFactsDataAccess4() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(222, funFactsDataAccess2.getLongestGamePlayedDate());
    }
    @Test
    public void testFunFactsDataAccess5() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(16, funFactsDataAccess2.getTotalSurrenders());
    }
    @Test
    public void testFunFactsDataAccess6() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(2234, funFactsDataAccess2.getTotalSnowballsHit());
    }
    @Test
    public void testFunFactsDataAccess7() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(2234, funFactsDataAccess2.getTotalPentakills());
    }
    @Test
    public void testFunFactsDataAccess8() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(2234, funFactsDataAccess2.getTotalKills());
    }
    @Test
    public void testFunFactsDataAccess9() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(2234, funFactsDataAccess2.getTotalWins());
    }
    @Test
    public void testFunFactsDataAccess10() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(2234, funFactsDataAccess2.getTotalSavedAllies());
    }
    @Test
    public void testFunFactsDataAccess11() throws Exception {
        RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";
        FunFacts funFactsDataAccess2 = funFactsDataAccess.fetchFunFacts(puuid, region);

        Assertions.assertEquals(2234, funFactsDataAccess2.getTotalSurvivedSingleDigitHp());
    }
}
