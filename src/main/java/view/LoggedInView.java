package view;

import java.awt.*;
import java.awt.event.ActionListener;

import data_access.RiotAPIChampionDataAccess;
import interface_adapter.button.ButtonController;
import interface_adapter.champion.ChampionController;
import interface_adapter.champion.ChampionPresenter;
import use_case.champion.FetchTopChampionsUseCase;

import javax.swing.*;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class LoggedInView extends JPanel implements ActionListener {
    private final ButtonController buttonController;
    private final JButton overviewButton = new JButton("Overview");
    private final JButton matchHistoryButton = new JButton("Match History");
    private final JButton friendsButton = new JButton("Friends");
    private final JButton championsButton = new JButton("Champions");
    private final JButton freeChampionRotationButton = new JButton("Free Champion Rotation");
    private final JButton funFactsButton = new JButton("Fun Facts");
    private final JButton logoutButton = new JButton("Log out");
    private final JPanel panel;
    private String puuid;
    private String region;

    public LoggedInView(String puuid, String region) {
        final JPanel firstPanel = new JPanel();
        this.buttonController = new ButtonController(puuid, region);
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));
        firstPanel.add(logoutButton);
        firstPanel.add(Box.createRigidArea(new Dimension(248, 0)));
        firstPanel.add(overviewButton);
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
        this.puuid = puuid;
        this.region = region;

        overviewButton.addActionListener(this);
        matchHistoryButton.addActionListener(this);
        friendsButton.addActionListener(this);
        championsButton.addActionListener(this);
        freeChampionRotationButton.addActionListener(this);
        funFactsButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    @SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:SuppressWarnings", "checkstyle:ParameterName"})
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == overviewButton) {
            this.buttonController.OverviewButtonClicked();
        }
        else if (e.getSource() == matchHistoryButton) {
            this.buttonController.MatchHistoryButtonClicked();
        }
        else if (e.getSource() == friendsButton) {
            this.buttonController.FriendsButtonClicked();
        }
        else if (e.getSource() == championsButton) {
            final ChampionPresenter championPresenter = new ChampionPresenter();
            final RiotAPIChampionDataAccess championDataAccess = new RiotAPIChampionDataAccess(puuid, region);
            final FetchTopChampionsUseCase championInteractor = new FetchTopChampionsUseCase(championDataAccess, championPresenter);
            final ChampionController championController = new ChampionController(championInteractor);
            new ChampionView(championController, championPresenter);
        }
        else if (e.getSource() == freeChampionRotationButton) {
            this.buttonController.FreeChampionRotationButtonClicked();
        }
        else if (e.getSource() == funFactsButton) {
            this.buttonController.FunFactsButtonClicked();
        }
        else if (e.getSource() == logoutButton) {
            this.buttonController.LogoutButtonClicked();
        }
    }

    public JPanel getPanel() {
        return this.panel;
    }
}