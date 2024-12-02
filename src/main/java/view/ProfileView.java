package view;

import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;
import interface_adapter.back.BackController;
import interface_adapter.profile.ProfileViewModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "profile";
    private final ProfileViewModel profileViewModel;
    private final BackController backController;
    private JPanel profilePanel;
    private JPanel rankPanel;
    private JPanel buttonPanel;
    private JButton backbutton = new JButton("Back");

    public ProfileView(ProfileViewModel profileViewModel, BackController backController) throws IOException {
        this.profileViewModel = profileViewModel;
        this.backController = backController;
        this.profileViewModel.addPropertyChangeListener(this);

        // Initialize main layout and panels
        this.setLayout(new BorderLayout());
        this.profilePanel = new JPanel();
        this.rankPanel = new JPanel();
        this.profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        this.rankPanel.setLayout(new BoxLayout(rankPanel, BoxLayout.Y_AXIS));

        // Button panel for the back button
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backbutton.addActionListener(this);
        buttonPanel.add(backbutton);

        // Add the button panel to the top of the main layout
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(profilePanel, BorderLayout.CENTER);
        this.add(rankPanel, BorderLayout.SOUTH);
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
        // Update profile icon
        ImageIcon profileIcon = profileViewModel.getState().getProfileIcon();
        JLabel profileIconLabel = new JLabel(profileIcon);
        profileIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.profilePanel.add(profileIconLabel);
        this.profilePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Profile stats panel
        JPanel profileStatsPanel = createInfoPanel("Profile Stats", new String[]{
                profileViewModel.getState().getUsername() + "#" + profileViewModel.getState().getTagline(),
                "Level: " + profileViewModel.getState().getProfileLevel(),
        });
        this.profilePanel.add(profileStatsPanel);
        this.profilePanel.add(Box.createRigidArea(new Dimension(30, 50)));

        // Rank icon and rank stats
        ImageIcon rankIcon = profileViewModel.getState().getRankIcon();
        final Image scaledImage = rankIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel rankIconLabel = new JLabel(new ImageIcon(scaledImage));
        rankIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.rankPanel.add(rankIconLabel);
        this.rankPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel performanceStatsPanel = createInfoPanel("Ranked Stats", new String[]{
                "Rank: " + profileViewModel.getState().getRank() + " " + profileViewModel.getState().getDivision(),
                "Game Mode: " + profileViewModel.getState().getGameMode(),
                "LP: " + profileViewModel.getState().getLeaguePoints(),
                "Wins: " + profileViewModel.getState().getWins(),
                "Losses: " + profileViewModel.getState().getLosses(),
                "Win Rate: " + profileViewModel.getState().getWinRate() + "%",
        });
        this.rankPanel.add(performanceStatsPanel);
    }

    public String getViewName() {
        return viewName;
    }
}
