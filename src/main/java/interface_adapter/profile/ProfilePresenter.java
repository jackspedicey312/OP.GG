package interface_adapter.profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.matchHistory.MatchHistoryViewModel;
import use_case.overview.OverviewOutputBoundary;

import javax.swing.*;

public class ProfilePresenter implements OverviewOutputBoundary {
    private final ProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ProfilePresenter(ProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView() {
        viewManagerModel.setState(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
