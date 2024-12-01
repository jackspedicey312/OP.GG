package view;

import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;
import interface_adapter.back.BackController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Main Profile";
    private final ProfileViewModel profileViewModel;
    private final BackController backController;
    private final JPanel mainPanel = new JPanel();

    public ProfileView(ProfileViewModel profileViewModel, BackController backController) throws IOException {
        this.profileViewModel = profileViewModel;
        this.backController = backController;

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Title Section
        JLabel title = new JLabel("Player Profile");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        backController.execute();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // SummonerIcon Section
        ImageIcon profileIcon = profileViewModel.getState().getProfileIcon();
        JLabel profileIconLabel = new JLabel(profileIcon);
        profileIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(profileIconLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Profile Stats Section
        JPanel profileStatsPanel = createInfoPanel("Profile Stats", new String[]{
                "Level: " + profileViewModel.getState().getProfileLevel(),

        });
        mainPanel.add(profileStatsPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        // Rank Stats Section
        ImageIcon rankIcon = profileViewModel.getState().getRankIcon();
        JLabel rankIconLabel = new JLabel(rankIcon);
        rankIconLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(rankIconLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel performanceStatsPanel = createInfoPanel("Performance Stats", new String[]{
                "Rank: " + profileViewModel.getState().getRank() + " " + profileViewModel.getState().getDivision(),
                "Game Mode: " + profileViewModel.getState().getGameMode(),
                "LP: " + profileViewModel.getState().getLeaguePoints(),
                "Wins: " + profileViewModel.getState().getWins(),
                "Losses: " + profileViewModel.getState().getLosses(),
                "Win Rate: " + profileViewModel.getState().getWinRate() + "%",
        });
        mainPanel.add(performanceStatsPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);

        setVisible(true);
    }

    public String getViewName() {
        return viewName;
    }
}
