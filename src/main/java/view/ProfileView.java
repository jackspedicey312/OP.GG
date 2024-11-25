package view;

import interface_adapter.profile.ProfilePresenter;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    public ProfileView(ProfilePresenter profile) {
        setTitle("Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Player Profile");
        title.setFont(new Font("Arial", Font.BOLD, 18));
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

        final JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

        setVisible(true);
    }
}
