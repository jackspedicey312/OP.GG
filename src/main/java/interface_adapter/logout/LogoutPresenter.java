package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import use_case.logout.LogoutOutputBoundary;

public class LogoutPresenter implements LogoutOutputBoundary {
    private final ViewManagerModel viewManagerModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void logout() {
        viewManagerModel.setState("login");
        viewManagerModel.firePropertyChanged();
    }

}
