package view;

import interface_adapter.back.BackController;
import interface_adapter.funfacts.FunFactPresenter;
import interface_adapter.funfacts.FunFactViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FunFactView extends JPanel implements ActionListener, PropertyChangeListener {
    private final FunFactViewModel funFactViewModel;
    private final BackController backController;
    private JButton backbutton = new JButton("Back");

    public FunFactView(FunFactViewModel funFactViewModel, BackController backController) {
        this.funFactViewModel = funFactViewModel;
        this.backController = backController;
        this.funFactViewModel.addPropertyChangeListener(this);

        // Main panel with padding
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Back button
        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backbutton.addActionListener(this);
        buttonPanel.add(backbutton);
        this.add(buttonPanel, BorderLayout.NORTH);

        // Title
        JLabel title = new JLabel("Fun Facts", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel titlePanel = new JPanel();
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        this.add(title, BorderLayout.CENTER);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        backController.execute();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Helper method to add labeled statistics
        // Content panel for stats
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setMinimumSize(new Dimension(800, 600));
        contentPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid with two columns
        addStat(contentPanel, "The oldest match analyzed:", funFactViewModel.getState().getOldestGamePlayed());
        addStat(contentPanel, "Total Playtime (Hours):", funFactViewModel.getState().getTotalPlaytime());
        addStat(contentPanel, "Total Wins:", funFactViewModel.getState().getTotalWins());
        addStat(contentPanel, "Total Losses:", funFactViewModel.getState().getTotalLosses());
        addStat(contentPanel, "Total Kills:", funFactViewModel.getState().getTotalKills());
        addStat(contentPanel, "Total Deaths:", funFactViewModel.getState().getTotalDeaths());
        addStat(contentPanel, "Longest game you played (Minutes):", funFactViewModel.getState().getLongestGamePlayed());
        addStat(contentPanel, "What a great use of time! You played that super long game on :",
                funFactViewModel.getState().getLongestGamePlayedDate());
        addStat(contentPanel, "Total times you have surrendered:", funFactViewModel.getState().getTotalSurrenders());
        addStat(contentPanel, "Total Pentakills:", funFactViewModel.getState().getTotalPentakills());
        addStat(contentPanel, "Total times you have survived with single digit HP:",
                funFactViewModel.getState().getTotalSurvivedSingleDigitHp());
        addStat(contentPanel, "Total Snowballs Hit:", funFactViewModel.getState().getTotalSnowballsHit());
        addStat(contentPanel, "Total times you have saved your teammate:", funFactViewModel.getState().getTotalSavedAllies());
        this.add(contentPanel, BorderLayout.SOUTH);
    }
}
