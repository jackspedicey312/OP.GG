package use_case.overview;

import data_access.RiotAPIProfileDataAccess;
import use_case.button.ButtonUseCase;

import java.io.IOException;

public class OverviewUseCase implements ButtonUseCase {
    private final RiotAPIProfileDataAccess profileDataAccess;
    private final OverviewOutputBoundary presenter;

    public OverviewUseCase(RiotAPIProfileDataAccess profileDataAccess, OverviewOutputBoundary presenter) {
        this.profileDataAccess = profileDataAccess;
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
