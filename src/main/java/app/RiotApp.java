package app;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchController;
import interface_adapter.match.MatchPresenter;
import interface_adapter.champion.ChampionController;
import interface_adapter.champion.ChampionPresenter;
import use_case.login.LoginInteractor;
import use_case.match.FetchRecentMatchesUseCase;
import use_case.champion.FetchTopChampionsUseCase;
import data_access.RiotAPIUserDataAccess;
import data_access.RiotAPIMatchDataAccess;
import data_access.RiotAPIChampionDataAccess;
import view.LoginView;
import view.ChampionView;

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

        // Initialize champion components
        final ChampionPresenter championPresenter = new ChampionPresenter();
        final RiotAPIChampionDataAccess championDataAccess = new RiotAPIChampionDataAccess();
        final FetchTopChampionsUseCase championInteractor = new FetchTopChampionsUseCase(championDataAccess, championPresenter);
        final ChampionController championController = new ChampionController(championInteractor);

        // Launch Champion View for demonstration purposes (can also be part of LoginView)
        new ChampionView(championController, championPresenter);

        // Pass MatchPresenter to LoginView (optional if you want to start from login)
        // new LoginView(loginController, matchController, loginPresenter, matchPresenter);
    }
}
