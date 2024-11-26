package app;

import java.awt.CardLayout;
import java.io.IOException;

import data_access.*;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.freeChampionRotation.FreeChampionRotationPresenter;
import interface_adapter.freeChampionRotation.FreeChampionRotationViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.match.MatchController;
import interface_adapter.match.MatchPresenter;
import interface_adapter.champion.ChampionController;
import interface_adapter.champion.ChampionPresenter;
import interface_adapter.profile.ProfilePresenter;
import use_case.freechampionrotation.FreeChampionRotationInputBoundary;
import use_case.freechampionrotation.FreeChampionRotationInteractor;
import use_case.freechampionrotation.FreeChampionRotationOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.match.FetchRecentMatchesUseCase;
import use_case.champion.FetchTopChampionsUseCase;
import use_case.overview.OverviewUseCase;
import view.*;

import javax.swing.*;

/**
 * RiotApp sets up and launches the application.
 */
public class RiotApp {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new UserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final RiotUserDataAccessObject userDataAccessObject = new RiotUserDataAccessObject();

    private LoginView loginView;
    private LoginViewModel loginViewModel;
    private LoggedInView loggedInView;
    private LoggedinViewModel loggedinViewModel;
    private FreeChampionRotationView freeChampionRotationView;
    private FreeChampionRotationViewModel freeChampionRotationViewModel;

    public RiotApp addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, "Login");
        return this;
    }

    public RiotApp addFreeChampionRotationView() throws IOException {
        freeChampionRotationViewModel = new FreeChampionRotationViewModel();
        freeChampionRotationView = new FreeChampionRotationView(freeChampionRotationViewModel);
        cardPanel.add(freeChampionRotationView);
        return this;
    }

    public RiotApp addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(loginViewModel, loggedinViewModel, viewManagerModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public RiotApp addFreeChampionRotationUseCase() {
        final FreeChampionRotationOutputBoundary freeChampionRotationOutputBoundary = new FreeChampionRotationPresenter();
        final FreeChampionRotationInputBoundary freeChampionRotationInteractor = new FreeChampionRotationInteractor();
        final FreeChampionRotationController freeChampionRotationController = new FreeChampionRotationController(freeChampionRotationInteractor);

        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(loggedInView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
