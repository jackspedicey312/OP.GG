package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.freeChampionRotation.FreeChampionRotationState;
import interface_adapter.freeChampionRotation.FreeChampionRotationViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import view.LoggedInState;
import view.LoggedInViewModel;

/**
 * Presenter for handling login output.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final FreeChampionRotationViewModel freeChampionRotationViewModel;
    private final ViewManagerModel managerModel;

    public LoginPresenter(LoginViewModel loginViewModel,
                          LoggedInViewModel loggedInViewModel,
                          FreeChampionRotationViewModel freeChampionRotationViewModel,
                          ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.freeChampionRotationViewModel = freeChampionRotationViewModel;
        this.managerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        final LoggedInState loggedInState = loggedInViewModel.getState();
        final FreeChampionRotationState freeChampionRotationState = freeChampionRotationViewModel.getState();
        loggedInState.setUser(outputData.getUser());
        freeChampionRotationState.setFreeChampionRotation(outputData.getFreeChampionRotation());

        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.freeChampionRotationViewModel.setState(freeChampionRotationState);
        this.freeChampionRotationViewModel.firePropertyChanged();

        this.managerModel.setState(LoggedInViewModel.getViewName());
        this.managerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(LoginOutputData outputData) {
        final LoginState loginState = loginViewModel.getState();

    }
}
