package use_case.logout;

import data_access.RiotUserDataAccessObject;
import use_case.login.LoginUserDataAccessInterface;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private RiotUserDataAccessObject userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute(LogoutInputData logoutInputData) {
        userDataAccessObject.setCurrentUsername(null);
        userDataAccessObject.setCurrentTagline(null);
        logoutPresenter.prepareSuccessView(new LogoutOutputData(logoutInputData.getUsername(), false));
    }
}