package view;

import interface_adapter.profile.ProfilePresenter;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    public ProfileView(ProfilePresenter profile) {
        setTitle("Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Player Profile");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        final ImageIcon profileIcon = profile.getProfileIcon();
        final JLabel profileIconLabel = new JLabel(profileIcon);
        profileIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(profileIconLabel);

        final int profileLevel = profile.getProfileLevel();
        final JLabel profileLevelLabel = new JLabel(String.valueOf(profileLevel));
        profileLevelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(profileLevelLabel);

        final String gameMode = profile.getGameMode();
        final JLabel gameModeLabel = new JLabel(gameMode);
        gameModeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(gameModeLabel);

        final String profileRank = profile.getRank();
        final JLabel profileRankLabel = new JLabel(profileRank);
        profileRankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(profileRankLabel);

        final String profileDivision = profile.getDivision();
        final JLabel profileDivisionLabel = new JLabel(profileDivision);
        profileDivisionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(profileDivisionLabel);

        final int profileLeaguePoints = profile.getLeaguePoints();
        final JLabel profileLeaguePointsLabel = new JLabel(String.valueOf(profileLeaguePoints));
        profileLeaguePointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(profileLeaguePointsLabel);

        final int profileWins = profile.getWins();
        final JLabel profileWinsLabel = new JLabel(String.valueOf(profileWins));
        profileWinsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(profileWinsLabel);

        final int profileLosses = profile.getLosses();
        final JLabel profileLossesLabel = new JLabel(String.valueOf(profileLosses));
        profileLossesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(profileLossesLabel);

        final int profileWinRate = profile.getWinRate();
        final JLabel profileWinRateLabel = new JLabel(String.valueOf(profileWinRate));
        profileWinRateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(profileWinRateLabel);

        final JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

        setVisible(true);
    }
}
