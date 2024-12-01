package interface_adapter.ProfilePresenter;

import use_case.overview.OverviewInputBoundary;

public class ProfileController {

    private final OverviewInputBoundary overviewInputBoundary;

    public ProfileController(OverviewInputBoundary overviewInputBoundary) {
        this.overviewInputBoundary = overviewInputBoundary;

    }

    public void execute() {
        overviewInputBoundary.execute();
    }

    public void fetchOverview(String puuid, String region) {
        overviewInputBoundary.fetchOverview(puuid, region);
    }
}