package app;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchController;
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
        final LoginPresenter loginPresenter = new LoginPresenter();
        final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
        final LoginInteractor loginInteractor = new LoginInteractor(userDataAccess, loginPresenter);
        final LoginController loginController = new LoginController(loginInteractor);

        // Initialize match components
        final MatchPresenter matchPresenter = new MatchPresenter();
        final RiotAPIMatchDataAccess matchDataAccess = new RiotAPIMatchDataAccess();
        final FetchRecentMatchesUseCase matchInteractor = new FetchRecentMatchesUseCase(matchDataAccess, matchPresenter);
        final MatchController matchController = new MatchController(matchInteractor);

        // Pass MatchPresenter to LoginView
        new LoginView(loginController, matchController, loginPresenter, matchPresenter);
    }
}
