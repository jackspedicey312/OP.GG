package use_case.overview;

import data_access.RiotAPIProfileDataAccess;
import data_access.RiotAPIRankDataAccess;

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
            profiledataAccess.generateProfileData(puuid, region);
            presenter.presentProfileIcon(profiledataAccess.getIconPng());
            presenter.presentProfileLevel(profiledataAccess.getSummonerLevel());

            final String summonerId = profiledataAccess.getSummonerID();
            rankDataAccess.generateRank(summonerId, region);

            presenter.presentGamemode(rankDataAccess.getGameMode());
            presenter.presentRank(rankDataAccess.getRank());
            presenter.presentDivision(rankDataAccess.getDivision());
            presenter.presentWins(rankDataAccess.getWins());
            presenter.presentLosses(rankDataAccess.getLosses());
            presenter.presentLeaguePoints(rankDataAccess.getLeaguePoints());
            presenter.presentWinRate(rankDataAccess.getWinRate());

        }
        catch (IOException e) {
            presenter.presentError("Failed to fetch profile" + e.getMessage());
        }
    }

    @Override
    public void execute() {

    }
}
