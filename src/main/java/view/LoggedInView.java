package view;

import java.awt.*;
import java.awt.event.ActionListener;

import interface_adapter.champion.ChampionController;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.funfacts.FunFactController;
import interface_adapter.ProfilePresenter.ProfileController;
import interface_adapter.logout.LogoutController;
import interface_adapter.matchHistory.MatchHistoryController;

import javax.swing.*;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class LoggedInView extends JPanel implements ActionListener {
    private final String viewName = "loggedIn";
    private final JButton profileButton = new JButton("Profile");
    private final JButton matchHistoryButton = new JButton("Match History");
    private final JButton championsButton = new JButton("Champions");
    private final JButton freeChampionRotationButton = new JButton("Free Champion Rotation");
    private final JButton funFactsButton = new JButton("Fun Facts");
    private final JButton logoutButton = new JButton("Log out");

    private final LoggedInViewModel loggedInViewModel;

    private final ProfileController profileController;
    private final MatchHistoryController matchHistoryController;
    private final FreeChampionRotationController freeChampionRotationController;
    private final FunFactController funFactController;
    private final ChampionController championController;
    private final LogoutController logoutController;

    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        ProfileController profileController,
                        FreeChampionRotationController freeChampionRotationController,
                        MatchHistoryController matchHistoryController,
                        FunFactController funFactController, ChampionController championController,
                        LogoutController logoutController) {
        this.loggedInViewModel = loggedInViewModel;
        this.profileController = profileController;
        this.freeChampionRotationController = freeChampionRotationController;
        this.funFactController = funFactController;
        this.matchHistoryController = matchHistoryController;
        this.championController = championController;
        this.logoutController = logoutController;

        final JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));
        firstPanel.add(logoutButton);
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        secondPanel.add(profileButton);
        secondPanel.add(matchHistoryButton);
        secondPanel.add(championsButton);
        secondPanel.add(freeChampionRotationButton);
        secondPanel.add(funFactsButton);
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        add(mainPanel);

        matchHistoryButton.addActionListener(this);
        profileButton.addActionListener(this);
        championsButton.addActionListener(this);
        freeChampionRotationButton.addActionListener(this);
        funFactsButton.addActionListener(this);
        championsButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    @SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:SuppressWarnings", "checkstyle:ParameterName"})
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == freeChampionRotationButton) {
            freeChampionRotationController.execute();
        }
        else if (e.getSource() == matchHistoryButton) {
            matchHistoryController.execute();
        }
        else if (e.getSource() == funFactsButton) {
            funFactController.execute();
        }
        else if (e.getSource() == profileButton) {
            profileController.execute();
        }
        else if (e.getSource() == championsButton) {
            championController.execute();
        }
        else if (e.getSource() == logoutButton) {
            logoutController.execute();
        }

    }

    public String getViewName() {
        return viewName;
    }

}