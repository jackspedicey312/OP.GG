package use_case.overview;

import data_access.RiotAPIProfileDataAccess;
import use_case.button.ButtonUseCase;

import java.io.IOException;

public class OverviewUseCase implements ButtonUseCase {
    private final OverviewOutputBoundary presenter;
    private final String puuid;
    private final String region;

    public OverviewUseCase(OverviewOutputBoundary presenter, String puuid, String region) {
        this.presenter = presenter;
        this.puuid = puuid;
        this.region = region;
    }

    public void fetchOverview() {
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
