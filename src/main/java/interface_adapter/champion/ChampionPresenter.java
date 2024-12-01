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
    public void presentChampions(List<Champion> champions) {
        ChampionState state = championViewModel.getState();
        state.setChampions(champions);
        championViewModel.setState(state);
        championViewModel.firePropertyChanged();
    }

    public void prepareView() {
        viewManagerModel.setState(championViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
