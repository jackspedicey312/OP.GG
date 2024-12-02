package use_case.champion;

import data_access.RiotAPIChampionDataAccess;

public class ChampionInteractor implements ChampionInputBoundary {
    private final ChampionOutputBoundary championPresenter;
    private final RiotAPIChampionDataAccess championDataAccess;

    public ChampionInteractor(ChampionOutputBoundary championPresenter, RiotAPIChampionDataAccess championDataAccess) {
        this.championPresenter = championPresenter;
        this.championDataAccess = championDataAccess;
    }
    // execute presenter

    @Override
    public void execute() {
        championPresenter.prepareView();
    }
}


