package view;

import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ProfileView extends JFrame {
    private final ProfileViewModel profileViewModel;

    public ProfileView(ProfileViewModel profileViewModel) throws IOException {
        this.profileViewModel = profileViewModel;
        setTitle("Player Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Title Section
        JLabel title = new JLabel("Player Profile");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // SummonerIcon Section
        ImageIcon profileIcon = profilePresenter.getProfileIcon();
        JLabel profileIconLabel = new JLabel(profileIcon);
        profileIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(profileIconLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Profile Stats Section
        JPanel profileStatsPanel = createInfoPanel("Profile Stats", new String[]{
                "Level: " + profilePresenter.getProfileLevel(),

        });
        mainPanel.add(profileStatsPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        // Rank Stats Section
        ImageIcon rankIcon = profilePresenter.getRankIcon();
        JLabel rankIconLabel = new JLabel(rankIcon);
        rankIconLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(rankIconLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel performanceStatsPanel = createInfoPanel("Performance Stats", new String[]{
                "Rank: " + profilePresenter.getRank() + " " + profilePresenter.getDivision(),
                "Game Mode: " + profilePresenter.getGameMode(),
                "LP: " + profilePresenter.getLeaguePoints(),
                "Wins: " + profilePresenter.getWins(),
                "Losses: " + profilePresenter.getLosses(),
                "Win Rate: " + profilePresenter.getWinRate() + "%",
        });
        mainPanel.add(performanceStatsPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);

        setVisible(true);
    }

    /**
     * Creates a labeled panel for displaying grouped information.
     *
     * @param title    the title of the panel.
     * @param infoRows an array of strings containing the information to display.
     * @return a JPanel containing the information.
     */
    private JPanel createInfoPanel(String title, String[] infoRows) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (String info : infoRows) {
            JLabel label = new JLabel(info);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(label);
            panel.add(Box.createRigidArea(new Dimension(0, 5))); // Spacing between rows
        }

        return panel;
    }
}
