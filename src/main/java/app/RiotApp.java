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
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.back.BackInputBoundary;
import use_case.back.BackInteractor;
import use_case.back.BackOutputBoundary;
import use_case.freechampionrotation.FreeChampionRotationInputBoundary;
import use_case.freechampionrotation.FreeChampionRotationInteractor;
import use_case.freechampionrotation.FreeChampionRotationOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
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
    private ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final RiotUserDataAccessObject userDataAccessObject = new RiotUserDataAccessObject();
    private LoginController loginController;
    private FreeChampionRotationController freeChampionRotationController;
    private BackController backController;

    private LoginView loginView;
    private LoginViewModel loginViewModel;
    private LoggedInView loggedInView;
    private LoggedInViewModel loggedInViewModel;
    private FreeChampionRotationView freeChampionRotationView;
    private FreeChampionRotationViewModel freeChampionRotationViewModel;

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
        loggedInView = new LoggedInView(loggedInViewModel, freeChampionRotationController);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    public RiotApp addFreeChampionRotationView() throws IOException {
        freeChampionRotationViewModel = new FreeChampionRotationViewModel();
        freeChampionRotationView = new FreeChampionRotationView(freeChampionRotationViewModel);
        cardPanel.add(freeChampionRotationView, freeChampionRotationView.getViewName());
        return this;
    }

    public RiotApp addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(loginViewModel, loggedInViewModel,
                freeChampionRotationViewModel, viewManagerModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, loginOutputBoundary);
        loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public RiotApp addFreeChampionRotationUseCase() {
        final FreeChampionRotationOutputBoundary freeChampionRotationOutputBoundary = new FreeChampionRotationPresenter(freeChampionRotationViewModel, viewManagerModel);
        final FreeChampionRotationInputBoundary freeChampionRotationInteractor = new FreeChampionRotationInteractor(freeChampionRotationOutputBoundary);
        freeChampionRotationController = new FreeChampionRotationController(freeChampionRotationInteractor);
        return this;
    }

    public RiotApp addBackUseCase() {
        final BackOutputBoundary backPresenter = new BackPresenter(viewManagerModel);
        final BackInputBoundary backInteractor = new BackInteractor(backPresenter);
        backController = new BackController(backInteractor);
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
