package data_access;

import entity.freeChampionRotation.FreeChampionRotation;
import entity.freeChampionRotation.FreeChampionRotationFactory;
import entity.match.Match;
import entity.match.MatchFactory;
import entity.matchHistory.MatchHistory;
import entity.matchHistory.MatchHistoryFactory;
import entity.playerStats.PlayerStatsFactory;
import entity.user.User;
import entity.user.UserFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import use_case.login.LoginUserDataAccessInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RiotUserDataAccessObject implements LoginUserDataAccessInterface {
    private User user;

    private final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
    private final RiotAPIMatchDataAccess matchDataAccess = new RiotAPIMatchDataAccess();
    private final RiotAPIFreeRotationDataAccess freeRotationDataAccess = new RiotAPIFreeRotationDataAccess();
    private final UserFactory userFactory = new UserFactory();
    private final MatchHistoryFactory matchHistoryFactory = new MatchHistoryFactory();
    private final MatchFactory matchFactory = new MatchFactory();
    private final PlayerStatsFactory playerStatsFactory = new PlayerStatsFactory();
    private final FreeChampionRotationFactory freeChampionRotationFactory = new FreeChampionRotationFactory();

    public User getUser(String username, String tagline, String region) throws Exception {
        return userFactory.createUser(username, tagline, region, userDataAccess.fetchPuuId(username, tagline, region));
    }

    public MatchHistory getMatchList(String puuId, String region, int count) throws Exception {
        List<Match> matchList = new ArrayList<>();
        final List<String> matchListId = matchDataAccess.fetchRecentMatchIds(puuId, region, count);
        for (String matchId : matchListId) {
            final JSONObject matchData = matchDataAccess.fetchMatchDetails(matchId, region);
            JSONArray participants = matchData.getJSONObject("metaData").getJSONArray("participants")
            for (int i = 0; i < participants.length(); i++ ) {
                if
            }


        }
    }

    public FreeChampionRotation getFreeChampionRotation() throws IOException {
        return freeChampionRotationFactory.createFreeChampionRotation(freeRotationDataAccess.getFreeChampionsNames(),
                freeRotationDataAccess.getFreeChampionsIcons());
    }
}
