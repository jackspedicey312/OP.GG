package use_case.champion;

public class ChampionInteractor implements ChampionInputBoundary {
    private final ChampionOutputBoundary championPresenter;

    public ChampionInteractor(ChampionOutputBoundary championPresenter) {
        this.championPresenter = championPresenter;
    }

    @Override
    public void execute() {
        championPresenter.prepareView();
    }
}

