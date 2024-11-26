package use_case.overview;

import data_access.RiotAPIProfileDataAccess;

import java.io.IOException;

public class OverviewUseCase implements OverviewInputBoundary {

    private final RiotAPIProfileDataAccess dataAccess;
    private final OverviewOutputBoundary presenter;

    // NEEDS DATA ACCESS AND PRESENTER TO INITIALIZE NO MATTER WHAT.
    public OverviewUseCase(RiotAPIProfileDataAccess profileDataAccess, OverviewOutputBoundary presenter) {
        this.dataAccess = profileDataAccess;
        this.presenter = presenter;
    }

    public void fetchOverview(String puuid, String region) {
        try {
            final RiotAPIProfileDataAccess profile = new RiotAPIProfileDataAccess();
            profile.generateProfileData(puuid, region);
            presenter.presentProfileIcon(profile.getIconPng());
            presenter.presentProfileLevel(profile.getSummonerLevel());

        }
        catch (IOException e) {

            presenter.presentError("Failed to fetch profile" + e.getMessage());
        }
    }

    @Override
    public void execute() {

    }
}
