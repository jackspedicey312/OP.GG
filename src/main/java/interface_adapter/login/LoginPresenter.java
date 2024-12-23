package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.champion.ChampionState;
import interface_adapter.champion.ChampionViewModel;
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
    private final ChampionViewModel championViewModel;

    public LoginPresenter(LoginViewModel loginViewModel,
                          LoggedInViewModel loggedInViewModel,
                          ProfileViewModel profileViewModel,
                          MatchHistoryViewModel matchHistoryViewModel,
                          FreeChampionRotationViewModel freeChampionRotationViewModel,
                          FunFactViewModel funFactViewModel, ChampionViewModel championViewModel,
                          ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.profileViewModel = profileViewModel;
        this.matchHistoryViewModel = matchHistoryViewModel;
        this.freeChampionRotationViewModel = freeChampionRotationViewModel;
        this.funFactViewModel = funFactViewModel;
        this.championViewModel = championViewModel;
        this.managerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        final LoggedInState loggedInState = loggedInViewModel.getState();
        final ProfileState profileState = profileViewModel.getState();
        final MatchHistoryState matchHistoryState = matchHistoryViewModel.getState();
        final FreeChampionRotationState freeChampionRotationState = freeChampionRotationViewModel.getState();
        final FunFactState funFactState = funFactViewModel.getState();
        final ChampionState championState = championViewModel.getState();
        final LoginState loginState = loginViewModel.getState();

        loggedInState.setUser(outputData.getUser());
        profileState.setProfileOverview(outputData.getProfileOverview());
        profileState.setRank(outputData.getRank());
        matchHistoryState.setMatchHistory(outputData.getMatchHistory());
        freeChampionRotationState.setFreeChampionRotation(outputData.getFreeChampionRotation());
        championState.setChampion(outputData.getChampion());
        funFactState.setFunFacts(outputData.getFunFacts());

        this.loggedInViewModel.setState(loggedInState);

        this.profileViewModel.setState(profileState);
        this.profileViewModel.firePropertyChanged();

        this.matchHistoryViewModel.setState(matchHistoryState);
        this.matchHistoryViewModel.firePropertyChanged();

        this.freeChampionRotationViewModel.setState(freeChampionRotationState);
        this.freeChampionRotationViewModel.firePropertyChanged();

        this.funFactViewModel.setState(funFactState);
        this.funFactViewModel.firePropertyChanged();

        this.championViewModel.setState(championState);
        this.championViewModel.firePropertyChanged();

        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();

        this.managerModel.setState(loggedInViewModel.getViewName());
        this.managerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(LoginOutputData outputData) {
        final LoginState loginState = loginViewModel.getState();

    }
}
