package view;

import interface_adapter.funfacts.FunFactPresenter;

import javax.swing.*;
import java.awt.*;

public class FunFactView extends JFrame {

    public FunFactView(FunFactPresenter presenter) {

        // Set up frame
        setTitle("Fun Facts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Adjusted size for better layout
        setLocationRelativeTo(null);

        // Main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        // Title
        JLabel title = new JLabel("Fun Facts", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(title, BorderLayout.NORTH);

        // Content panel for stats
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid with two columns
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Helper method to add labeled statistics
        addStat(contentPanel, "The oldest match analyzed:", presenter.getOldestGamePlayed());
        addStat(contentPanel, "Total Playtime (Hours):", presenter.getTotalPlaytime());
        addStat(contentPanel, "Total Wins:", presenter.getTotalWins());
        addStat(contentPanel, "Total Losses:", presenter.getTotalLosses());
        addStat(contentPanel, "Total Kills:", presenter.getTotalKills());
        addStat(contentPanel, "Total Deaths:", presenter.getTotalDeaths());
        addStat(contentPanel, "Longest game you played (Minutes):", presenter.getLongestGamePlayed());
        addStat(contentPanel, "What a great use of time! You played that super long game on :",
                presenter.getLongestGamePlayedDate());
        addStat(contentPanel, "Total times you have surrendered:", presenter.getTotalSurrenders());
        addStat(contentPanel, "Total Pentakills:", presenter.getTotalPentakills());
        addStat(contentPanel, "Total times you have survived with single digit HP:",
                presenter.getTotalSurvivedSingleDigitHp());
        addStat(contentPanel, "Total Snowballs Hit:", presenter.getTotalSnowballsHit());
        addStat(contentPanel, "Total times you have saved your teammate:", presenter.getTotalSavedAllies());

        // Show frame
        setVisible(true);
    }

    /**
     * Helper method to add a statistic label and value to the panel.
     */
    private void addStat(JPanel panel, String labelText, Object value) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);

        JLabel valueLabel = new JLabel(String.valueOf(value));
        valueLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(valueLabel);
    }
}
