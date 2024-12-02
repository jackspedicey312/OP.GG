package interface_adapter.champion;

import entity.champion.Champion;
import interface_adapter.ViewManagerModel;
import use_case.champion.ChampionOutputBoundary;

import java.util.List;

public class ChampionPresenter implements ChampionOutputBoundary {
    private final ChampionViewModel championViewModel;
    private final ViewManagerModel viewManagerModel;

    public ChampionPresenter(ChampionViewModel championViewModel, ViewManagerModel viewManagerModel) {
        this.championViewModel = championViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView() {
        viewManagerModel.setState(championViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
