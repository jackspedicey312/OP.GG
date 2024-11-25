package use_case.overview;

import data_access.RiotAPIProfileDataAccess;
import use_case.button.ButtonUseCase;

import java.io.IOException;

public class OverviewUseCase implements ButtonUseCase {
    private final OverviewOutputBoundary presenter;
    private final RiotAPIProfileDataAccess profileDataAccess;

    public OverviewUseCase(RiotAPIProfileDataAccess profileDataAccess, OverviewOutputBoundary presenter) {

        this.profileDataAccess = profileDataAccess;
        this.presenter = presenter;
    }

    public void fetchOverview() {
        try {
            profileDataAccess.generateProfileData();
            presenter.presentProfileIcon(profileDataAccess.getIconPng());
            presenter.presentProfileLevel(profileDataAccess.getSummonerLevel());

        }
        catch (IOException e) {

            presenter.presentError("Failed to fetch profile" + e.getMessage());
        }
    }

    @Override
    public void execute() {

    }
}
