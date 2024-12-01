package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.freeChampionRotation.FreeChampionRotationState;
import interface_adapter.freeChampionRotation.FreeChampionRotationViewModel;
import interface_adapter.funfacts.FunFactState;
import interface_adapter.funfacts.FunFactViewModel;
import interface_adapter.matchHistory.MatchHistoryState;
import interface_adapter.matchHistory.MatchHistoryViewModel;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import view.*;

/**
 * Presenter for handling login output.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ProfileViewModel profileViewModel;
    private final MatchHistoryViewModel matchHistoryViewModel;
    private final FreeChampionRotationViewModel freeChampionRotationViewModel;
    private final FunFactViewModel funFactViewModel;
    private final ViewManagerModel managerModel;

    public LoginPresenter(LoginViewModel loginViewModel,
                          LoggedInViewModel loggedInViewModel,
                          ProfileViewModel profileViewModel,
                          MatchHistoryViewModel matchHistoryViewModel,
                          FreeChampionRotationViewModel freeChampionRotationViewModel,
                          FunFactViewModel funFactViewModel,
                          ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.profileViewModel = profileViewModel;
        this.matchHistoryViewModel = matchHistoryViewModel;
        this.freeChampionRotationViewModel = freeChampionRotationViewModel;
        this.funFactViewModel = funFactViewModel;
        this.managerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        final LoggedInState loggedInState = loggedInViewModel.getState();
        final ProfileState profileState = profileViewModel.getState();
        final MatchHistoryState matchHistoryState = matchHistoryViewModel.getState();
        final FreeChampionRotationState freeChampionRotationState = freeChampionRotationViewModel.getState();
        final FunFactState funFactState = funFactViewModel.getState();
        loggedInState.setUser(outputData.getUser());

        freeChampionRotationState.setFreeChampionRotation(outputData.getFreeChampionRotation());

        this.loggedInViewModel.setState(loggedInState);

        this.profileViewModel.setState();
        this.profileViewModel.firePropertyChanged();

        this.matchHistoryViewModel.setState();
        this.matchHistoryViewModel.firePropertyChanged();

        this.freeChampionRotationViewModel.setState(freeChampionRotationState);
        this.freeChampionRotationViewModel.firePropertyChanged();

        this.funFactViewModel.getState();
        this.funFactViewModel.firePropertyChanged();

        this.managerModel.setState(loggedInViewModel.getViewName());
        this.managerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(LoginOutputData outputData) {
        final LoginState loginState = loginViewModel.getState();

    }
}
