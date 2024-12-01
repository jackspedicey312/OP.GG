package use_case.overview;

import data_access.RiotAPIProfileDataAccess;
import data_access.RiotAPIRankDataAccess;
import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;

import java.io.IOException;

public class OverviewUseCase implements OverviewInputBoundary {

    private final RiotAPIProfileDataAccess profiledataAccess;
    private final OverviewOutputBoundary presenter;
    private final RiotAPIRankDataAccess rankDataAccess;

    // NEEDS DATA ACCESS AND PRESENTER TO INITIALIZE NO MATTER WHAT.
    public OverviewUseCase(RiotAPIProfileDataAccess profileDataAccess, RiotAPIRankDataAccess rankDataAccess,
                           OverviewOutputBoundary presenter) {
        this.profiledataAccess = profileDataAccess;
        this.rankDataAccess = rankDataAccess;
        this.presenter = presenter;
    }

    public void fetchOverview(String puuid, String region) {
        try {

            ProfileOverview profileOverview = profiledataAccess.generateProfileData(puuid, region);
            presenter.presentProfileIcon(profileOverview.getSummonerImage());
            presenter.presentProfileLevel(profileOverview.getSummonerLevel());

            final String summonerId = profileOverview.getSummonerID();
            Rank rank = rankDataAccess.generateRank(summonerId, region);
            presenter.presentGamemode(rank.getGameMode());
            presenter.presentRank(rank.getRank());
            presenter.presentDivision(rank.getDivision());
            presenter.presentWins(rank.getWins());
            presenter.presentLosses(rank.getLosses());
            presenter.presentLeaguePoints(rank.getLeaguePoints());
            presenter.presentWinRate(rank.getWinRate());
            presenter.presentRankIcon(rank.getRankImage());

        }
        catch (IOException e) {
            presenter.presentError("Failed to fetch profile" + e.getMessage());
        }
    }

    @Override
    public void execute() {

    }
}
