package interface_adapter.funfacts;

import interface_adapter.ViewManagerModel;
import interface_adapter.matchHistory.MatchHistoryViewModel;
import use_case.funfacts.FunFactsOutputBoundary;

public class FunFactPresenter implements FunFactsOutputBoundary {

    private final FunFactViewModel funFactViewModel;
    private final ViewManagerModel viewManagerModel;

    public FunFactPresenter(FunFactViewModel funFactViewModel, ViewManagerModel viewManagerModel) {
        this.funFactViewModel = funFactViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView() {
        viewManagerModel.setState(funFactViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
