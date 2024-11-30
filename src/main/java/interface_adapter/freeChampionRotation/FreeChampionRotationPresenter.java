package interface_adapter.freeChampionRotation;

import interface_adapter.ViewManagerModel;
import use_case.freechampionrotation.FreeChampionRotationOutputBoundary;

public class FreeChampionRotationPresenter implements FreeChampionRotationOutputBoundary {
    private final FreeChampionRotationViewModel freeChampionRotationViewModel;
    private final ViewManagerModel viewManagerModel;

    public FreeChampionRotationPresenter(FreeChampionRotationViewModel freeChampionRotationViewModel,
                                         ViewManagerModel viewmanagerModel) {
        this.freeChampionRotationViewModel = freeChampionRotationViewModel;
        this.viewManagerModel = viewmanagerModel;
    }

    public void prepareView() {
        viewManagerModel.setState(freeChampionRotationViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
