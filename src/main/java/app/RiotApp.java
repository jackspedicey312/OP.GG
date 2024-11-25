package app;

import interface_adapter.login.LoginController;
import interface_adapter.match.MatchController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchPresenter;
import use_case.login.LoginInteractor;
import use_case.match.FetchRecentMatchesUseCase;
import data_access.RiotAPIUserDataAccess;
import data_access.RiotAPIMatchDataAccess;
import view.LoginView;

/**
 * RiotApp sets up and launches the application.
 */
public class RiotApp {

    public void start() {
        // Initialize login components
        LoginPresenter loginPresenter = new LoginPresenter();
        RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccess, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);

        // Initialize match components
        MatchPresenter matchPresenter = new MatchPresenter();
        RiotAPIMatchDataAccess matchDataAccess = new RiotAPIMatchDataAccess();
        FetchRecentMatchesUseCase matchInteractor = new FetchRecentMatchesUseCase(matchDataAccess, matchPresenter);
        MatchController matchController = new MatchController(matchInteractor);

        // Launch the login view
        new LoginView(loginController, matchController, loginPresenter, matchPresenter);
    }
}

