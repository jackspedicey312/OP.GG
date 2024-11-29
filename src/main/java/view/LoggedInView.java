package view;

import java.awt.*;
import java.awt.event.ActionListener;

import data_access.RiotAPIChampionDataAccess;
import data_access.RiotUserDataAccessObject;
import interface_adapter.Champion.ChampionController;
import interface_adapter.Champion.ChampionPresenter;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.login.LoginController;
import use_case.champion.FetchTopChampionsUseCase;

import javax.swing.*;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class LoggedInView extends JPanel implements ActionListener {
    private final JButton matchHistoryButton = new JButton("Match History");
    private final JButton friendsButton = new JButton("Friends");
    private final JButton championsButton = new JButton("Champions");
    private final JButton freeChampionRotationButton = new JButton("Free Champion Rotation");
    private final JButton funFactsButton = new JButton("Fun Facts");
    private final JButton logoutButton = new JButton("Log out");
    private final JPanel panel;
    private final LoggedInViewModel loggedInViewModel;
    private final FreeChampionRotationController freeChampionRotationController;

    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        FreeChampionRotationController freeChampionRotationController) {
        this.loggedInViewModel = loggedInViewModel;
        this.freeChampionRotationController = freeChampionRotationController;

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
        this.panel = mainPanel;

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
        }
    }

    public JPanel getPanel() {
        return this.panel;
    }

}