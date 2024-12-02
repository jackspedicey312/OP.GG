package app;

import java.awt.CardLayout;
import java.io.IOException;

import data_access.*;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackController;
import interface_adapter.back.BackPresenter;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.freeChampionRotation.FreeChampionRotationPresenter;
import interface_adapter.freeChampionRotation.FreeChampionRotationViewModel;
import interface_adapter.funfacts.FunFactController;
import interface_adapter.funfacts.FunFactPresenter;
import interface_adapter.funfacts.FunFactViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.matchHistory.MatchHistoryController;
import interface_adapter.matchHistory.MatchHistoryPresenter;
import interface_adapter.matchHistory.MatchHistoryViewModel;
import interface_adapter.ProfilePresenter.ProfileController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.champion.ChampionController;
import interface_adapter.champion.ChampionPresenter;
import interface_adapter.champion.ChampionViewModel;
import use_case.back.BackInputBoundary;
import use_case.back.BackInteractor;
import use_case.back.BackOutputBoundary;
import use_case.freechampionrotation.FreeChampionRotationInputBoundary;
import use_case.freechampionrotation.FreeChampionRotationInteractor;
import use_case.freechampionrotation.FreeChampionRotationOutputBoundary;
import use_case.funfacts.FunFactsInputBoundary;
import use_case.funfacts.FunFactsOutputBoundary;
import use_case.funfacts.FunFactsUseCase;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.matchHistory.MatchHistoryInputBoundary;
import use_case.matchHistory.MatchHistoryInteractor;
import use_case.matchHistory.MatchHistoryOutputBoundary;
import use_case.overview.ProfileInputBoundary;
import use_case.overview.ProfileInteractor;
import use_case.overview.ProfileOutputBoundary;
import use_case.champion.ChampionInteractor;
import use_case.champion.ChampionInputBoundary;
import use_case.champion.ChampionOutputBoundary;
import view.*;

import javax.swing.*;

/**
 * RiotApp sets up and launches the application.
 */
public class RiotApp {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
    private final RiotUserDataAccessObject userDataAccessObject = new RiotUserDataAccessObject();
    private LoginController loginController;
    private ProfileController profileController;
    private MatchHistoryController matchHistoryController;
    private FreeChampionRotationController freeChampionRotationController;
    private BackController backController;
    private FunFactController funFactController;
    private ChampionController championController;
    private LogoutController logoutController;

    private LoginView loginView;
    private LoginViewModel loginViewModel;

    private LoggedInView loggedInView;
    private LoggedInViewModel loggedInViewModel;

    private ProfileView profileView;
    private ProfileViewModel profileViewModel;

    private MatchHistoryView matchHistoryView;
    private MatchHistoryViewModel matchHistoryViewModel;

    private FreeChampionRotationView freeChampionRotationView;
    private FreeChampionRotationViewModel freeChampionRotationViewModel;

    private FunFactView funFactView;
    private FunFactViewModel funFactViewModel;

    private ChampionMasteryView championMasteryView;
    private ChampionViewModel championViewModel;

    public RiotApp() {
        cardPanel.setLayout(cardLayout);
    }

    public RiotApp addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    public RiotApp addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel, profileController, freeChampionRotationController,
                matchHistoryController, funFactController, championController, logoutController);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    public RiotApp addProfileView() throws IOException {
        profileViewModel = new ProfileViewModel();
        profileView = new ProfileView(profileViewModel, backController);
        cardPanel.add(profileView, profileView.getViewName());
        return this;
    }

    public RiotApp addMatchHistoryView() {
        matchHistoryViewModel = new MatchHistoryViewModel();
        matchHistoryView = new MatchHistoryView(matchHistoryViewModel, backController);
        cardPanel.add(matchHistoryView, matchHistoryView.getViewName());
        return this;
    }

    public RiotApp addFunFactView() {
        funFactViewModel = new FunFactViewModel();
        funFactView = new FunFactView(funFactViewModel, backController);
        cardPanel.add(funFactView, funFactViewModel.getViewName());
        return this;
    }

    public RiotApp addFreeChampionRotationView() throws IOException {
        freeChampionRotationViewModel = new FreeChampionRotationViewModel();
        freeChampionRotationView = new FreeChampionRotationView(freeChampionRotationViewModel, backController);
        cardPanel.add(freeChampionRotationView, freeChampionRotationView.getViewName());
        return this;
    }

    public RiotApp addChampionView() throws IOException {
        championViewModel = new ChampionViewModel();
        championMasteryView = new ChampionMasteryView(championViewModel, backController);
        cardPanel.add(championMasteryView, championMasteryView.getViewName());
        return this;
    }

    public RiotApp addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(loginViewModel, loggedInViewModel, profileViewModel,
                matchHistoryViewModel, freeChampionRotationViewModel, funFactViewModel, viewManagerModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, loginOutputBoundary);
        loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public RiotApp addProfileUseCase() {
        final ProfileOutputBoundary profileOutputBoundary = new ProfilePresenter(profileViewModel, viewManagerModel);
        final ProfileInputBoundary profileInteractor = new ProfileInteractor(profileOutputBoundary);
        profileController = new ProfileController(profileInteractor);
        return this;
    }

    public RiotApp addMatchHistoryUseCase() {
        final MatchHistoryOutputBoundary matchHistoryOutputBoundary = new MatchHistoryPresenter(matchHistoryViewModel, viewManagerModel);
        final MatchHistoryInputBoundary matchHistoryInteractor = new MatchHistoryInteractor(matchHistoryOutputBoundary);
        matchHistoryController = new MatchHistoryController(matchHistoryInteractor);
        matchHistoryView.setBackController(backController);
        return this;
    }

    public RiotApp addFreeChampionRotationUseCase() {
        final FreeChampionRotationOutputBoundary freeChampionRotationOutputBoundary = new FreeChampionRotationPresenter(freeChampionRotationViewModel, viewManagerModel);
        final FreeChampionRotationInputBoundary freeChampionRotationInteractor = new FreeChampionRotationInteractor(freeChampionRotationOutputBoundary);
        freeChampionRotationController = new FreeChampionRotationController(freeChampionRotationInteractor);
        return this;
    }

    public RiotApp addFunFactsUseCase() {
        final FunFactsOutputBoundary funFactsOutputBoundary = new FunFactPresenter(funFactViewModel, viewManagerModel);
        final FunFactsInputBoundary funFactsInteractor = new FunFactsUseCase(funFactsOutputBoundary);
        funFactController = new FunFactController(funFactsInteractor);
        return this;
    }

    public RiotApp addChampionUseCase() {
        final ChampionOutputBoundary championOutputBoundary = new ChampionPresenter(championViewModel, viewManagerModel);
        final RiotAPIChampionDataAccess championDataAccess = new RiotAPIChampionDataAccess();
        final ChampionInputBoundary championInteractor = new ChampionInteractor(championOutputBoundary, championDataAccess);
        championController = new ChampionController(championInteractor);
        return this;
    }

    public RiotApp addBackUseCase() {
        final BackOutputBoundary backPresenter = new BackPresenter(viewManagerModel);
        final BackInputBoundary backInteractor = new BackInteractor(backPresenter);
        backController = new BackController(backInteractor);
        return this;
    }

    public RiotApp addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel);
        final LogoutInputBoundary logoutInteractor = new LogoutInteractor(logoutOutputBoundary);
        logoutController = new LogoutController(logoutInteractor);
        return this;
    }


    public JFrame build() {
        final JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(loginView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
