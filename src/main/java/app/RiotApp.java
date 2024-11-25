package app;

import data_access.RiotAPIProfileDataAccess;
import interface_adapter.ProfilePresenter.ProfileController;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchController;
import interface_adapter.match.MatchPresenter;
import interface_adapter.champion.ChampionController;
import interface_adapter.champion.ChampionPresenter;
import interface_adapter.profile.ProfilePresenter;
import use_case.login.LoginInteractor;
import use_case.match.FetchRecentMatchesUseCase;
import use_case.champion.FetchTopChampionsUseCase;
import data_access.RiotAPIUserDataAccess;
import data_access.RiotAPIMatchDataAccess;
import data_access.RiotAPIChampionDataAccess;
import use_case.overview.OverviewUseCase;
import view.LoginView;
import view.ChampionView;
import view.MatchView;

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

        // Launch Champion View for demonstration purposes (can also be part of LoginView)
        // new ChampionView(championController, championPresenter);

        // Initialize main profile.
        final ProfilePresenter profilePresenter = new ProfilePresenter();
        final RiotAPIProfileDataAccess profileDataAccess = new RiotAPIProfileDataAccess();
        final OverviewUseCase overviewUseCase = new OverviewUseCase(profileDataAccess, profilePresenter);
        final interface_adapter.ProfilePresenter.ProfileController profileController = new ProfileController(overviewUseCase);

        // Pass MatchPresenter to LoginView (optional if you want to start from login)
        new LoginView(loginController, profileController, profilePresenter, matchController, loginPresenter, matchPresenter);
    }
}
