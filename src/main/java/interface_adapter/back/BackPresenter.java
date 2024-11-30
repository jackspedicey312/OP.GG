package interface_adapter.back;

import interface_adapter.ViewManagerModel;
import use_case.back.BackOutputBoundary;

public class BackPresenter implements BackOutputBoundary {
    private final ViewManagerModel viewManagerModel;

    public BackPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView() {
        viewManagerModel.setState("loggedIn");
        viewManagerModel.firePropertyChanged();
    }
}
