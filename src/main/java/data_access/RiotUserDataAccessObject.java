package data_access;

import entity.*;
//import use_case.freechampionrotation.FreeChampionRotationUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class RiotUserDataAccessObject implements LoginUserDataAccessInterface {
//        FreeChampionRotationUserDataAccessInterface {
    private User user;

    private final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
    private final RiotAPIMatchDataAccess matchDataAccess = new RiotAPIMatchDataAccess();
    private final UserFactory userFactory = new UserFactory();
    private final MatchListFactory matchListFactory = new MatchListFactory();
    private final MatchFactory matchFactory = new MatchFactory();
    private final PlayerStatsFactory playerStatsFactory = new PlayerStatsFactory();

    public User getUser(String username, String tagline, String region) throws Exception {
        return userFactory.createUser(username, tagline, region, userDataAccess.fetchPuuId(username, tagline, region));
    }

    public MatchList getMatchList(String puuId, String region, int count) throws Exception {
        List<Match> matchList = new ArrayList<>();
        final List<String> matchListId = matchDataAccess.fetchRecentMatchIds(puuId, region, count);
        for (String matchId : matchListId) {
            matchDataAccess.fetchMatchDetails(matchId, region).;
        }
    }

}
