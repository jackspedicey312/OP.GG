package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import data_access.RiotAPIChampionDataAccess;
import data_access.RiotUserDataAccessObject;
import entity.match.Match;
import interface_adapter.Champion.ChampionController;
import interface_adapter.Champion.ChampionPresenter;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.funfacts.FunFactController;
import interface_adapter.login.LoginController;
import interface_adapter.ProfilePresenter.ProfileController;
import interface_adapter.matchHistory.MatchHistoryController;
import use_case.champion.FetchTopChampionsUseCase;

import javax.swing.*;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class LoggedInView extends JPanel implements ActionListener {
    private final String viewName = "loggedIn";
    private final JButton matchHistoryButton = new JButton("Match History");
    private final JButton friendsButton = new JButton("Friends");
    private final JButton championsButton = new JButton("Champions");
    private final JButton freeChampionRotationButton = new JButton("Free Champion Rotation");
    private final JButton funFactsButton = new JButton("Fun Facts");
    private final JButton logoutButton = new JButton("Log out");

    private final LoggedInViewModel loggedInViewModel;

    private final ProfileController profileController;
    private final MatchHistoryController matchHistoryController;
    private final FreeChampionRotationController freeChampionRotationController;
    private final FunFactController funFactController;

    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        ProfileController profileController,
                        FreeChampionRotationController freeChampionRotationController,
                        MatchHistoryController matchHistoryController,
                        FunFactController funFactController) {
        this.loggedInViewModel = loggedInViewModel;
        this.profileController = profileController;
        this.freeChampionRotationController = freeChampionRotationController;
        this.funFactController = funFactController;
        this.matchHistoryController = matchHistoryController;

        final JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));
        firstPanel.add(logoutButton);
        firstPanel.add(Box.createRigidArea(new Dimension(248, 0)));
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        secondPanel.add(matchHistoryButton);
        secondPanel.add(friendsButton);
        secondPanel.add(championsButton);
        secondPanel.add(freeChampionRotationButton);
        secondPanel.add(funFactsButton);
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        add(mainPanel);

        matchHistoryButton.addActionListener(this);
        friendsButton.addActionListener(this);
        championsButton.addActionListener(this);
        freeChampionRotationButton.addActionListener(this);
        funFactsButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    @SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:SuppressWarnings", "checkstyle:ParameterName"})
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == freeChampionRotationButton) {
            freeChampionRotationController.execute();
        } else if (e.getSource() == matchHistoryButton) {
            matchHistoryController.execute();
        } else if (e.getSource() == funFactsButton) {
            funFactController.execute();
        } else {
            profileController.execute();
        }
    }

    public String getViewName() {
        return viewName;
    }

}