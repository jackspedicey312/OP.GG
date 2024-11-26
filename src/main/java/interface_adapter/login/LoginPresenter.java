package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.overview.OverviewState;
import interface_adapter.overview.OverviewViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final OverviewViewModel overviewViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          OverviewViewModel overviewViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.OverviewViewModel = overviewViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        final OverviewState overviewState = overviewViewModel.getState();
       overviewState.setUsername(response.getUsername());
        this.overviewViewModel.setState(overviewState);
        this.overviewViewModel.firePropertyChanged();

        this.viewManagerModel.setState(overviewViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(error);
        loginViewModel.firePropertyChanged();
    }