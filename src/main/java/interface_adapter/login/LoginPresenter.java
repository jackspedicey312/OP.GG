package interface_adapter.login;

import interface_adapter.ViewManagerModel;
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
    private final ViewManagerModel managerModel;

    public LoginPresenter(LoginViewModel loginViewModel,
                          LoggedinViewModel loggedInViewModel,
                          ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.managerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        final LoggedInState loggedInState = loggedInViewModel.getState();

        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.managerModel.setState(LoggedInViewModel.getViewName());
        this.managerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(LoginOutputData outputData) {
        final LoginState loginState = loginViewModel.getState();


    }
}
