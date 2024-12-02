package interface_adapter.champion;

import interface_adapter.ViewManagerModel;
import use_case.champion.ChampionOutputBoundary;

public class ChampionPresenter implements ChampionOutputBoundary {
    private final ChampionViewModel championViewModel;
    private final ViewManagerModel viewManagerModel;

    public ChampionPresenter(ChampionViewModel championViewModel,
                                         ViewManagerModel viewmanagerModel) {
        this.championViewModel = championViewModel;
        this.viewManagerModel = viewmanagerModel;
    }

    public void prepareView() {
        viewManagerModel.setState(championViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

