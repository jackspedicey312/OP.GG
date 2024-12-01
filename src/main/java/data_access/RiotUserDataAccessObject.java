package data_access;

import entity.FunFacts.FunFactsFactory;
import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.ProfileOverviewFactory;
import entity.OverviewProfile.Rank;
import entity.OverviewProfile.RankFactory;
import entity.freeChampionRotation.FreeChampionRotation;
import entity.freeChampionRotation.FreeChampionRotationFactory;
import entity.match.Match;
import entity.match.MatchFactory;
import entity.matchHistory.MatchHistory;
import entity.matchHistory.MatchHistoryFactory;
import entity.playerStats.PlayerStatsFactory;
import entity.user.User;
import entity.user.UserFactory;

import org.json.JSONObject;
import use_case.login.LoginUserDataAccessInterface;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RiotUserDataAccessObject implements LoginUserDataAccessInterface {
    private User user;

    private final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
    private final RiotAPIMatchDataAccess matchDataAccess = new RiotAPIMatchDataAccess();
    private final RiotAPIFreeRotationDataAccess freeRotationDataAccess = new RiotAPIFreeRotationDataAccess();
    private final RiotAPIFunFactsDataAccess funFactsDataAccess = new RiotAPIFunFactsDataAccess();
    private final RiotAPIChampionIconDataAccess championIconDataAccess = new RiotAPIChampionIconDataAccess();
    private final RiotAPIProfileDataAccess profileDataAccess = new RiotAPIProfileDataAccess();

    private final UserFactory userFactory = new UserFactory();
    private final ProfileOverviewFactory profileOverviewFactory = new ProfileOverviewFactory();
    private final RankFactory rankFactory = new RankFactory();
    private final MatchHistoryFactory matchHistoryFactory = new MatchHistoryFactory();
    private final MatchFactory matchFactory = new MatchFactory();
    private final FreeChampionRotationFactory freeChampionRotationFactory = new FreeChampionRotationFactory();
    private final FunFactsFactory funFactsFactory = new FunFactsFactory();

    public User getUser(String username, String tagline, String region) throws Exception {
        return userFactory.createUser(username, tagline, region, userDataAccess.fetchPuuId(username, tagline, region));
    }

    public ProfileOverview getProfileOverview(String puuId, String region) {

        return profileOverviewFactory.createProfileOverview();
    }

    public Rank getRank() {
        return rankFactory.createRank();
    }

    public MatchHistory getMatchHistory(String puuId, String region, int count) throws Exception {
        final List<Match> matchList = new ArrayList<>();
        final List<String> matchListId = matchDataAccess.getRecentMatchIds(puuId, region, count);
        for (String matchId : matchListId) {
            final JSONObject matchData = matchDataAccess.getMatchDetails(matchId, region);
            final int j = funFactsDataAccess.getPlayerMatchIndex(puuId,
                    matchData.getJSONObject("metaData").getJSONArray("participants"));

            final JSONObject gameInfo = matchData.getJSONObject("info");
            final JSONObject playerData = gameInfo.getJSONArray("participants").getJSONObject(j);

            matchList.add(matchFactory.createMatch(
                    championIconDataAccess.getChampionIcon(playerData.getString("championName")),
                    playerData.getInt("kills"),
                    playerData.getInt("deaths"),
                    playerData.getInt("assists"),
                    playerData.getBoolean("win"),
                    gameInfo.getInt("gameDuration"),
                    gameInfo.getString("gameMode"),
                    gameInfo.getInt("gameCreation")));
        }
        return matchHistoryFactory.createMatchHistory(matchList);
    }

    public FreeChampionRotation getFreeChampionRotation() throws IOException {
        return freeChampionRotationFactory.createFreeChampionRotation(freeRotationDataAccess.getFreeChampionsNames(),
                freeRotationDataAccess.getFreeChampionsIcons());
    }
}
