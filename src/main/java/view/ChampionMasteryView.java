package view;

import interface_adapter.champion.ChampionViewModel;
import interface_adapter.back.BackController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ChampionView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "championView";
    private ChampionViewModel championViewModel;
    private JPanel mainPanel;
    private JPanel listPanel;
    private JPanel buttonPanel;
    private JButton backButton = new JButton("Back");
    private BackController backController;

    public ChampionView(ChampionViewModel championViewModel, BackController backController) {
        this.championViewModel = championViewModel;
        this.backController = backController;

        // Listen for changes in the ViewModel
        this.championViewModel.addPropertyChangeListener(this);

        // Set up main panel
        this.mainPanel = new JPanel(new BorderLayout());
        this.listPanel = new JPanel();
        listPanel.setBorder(BorderFactory.createTitledBorder("Champion Details"));
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Set up button panel with back button
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backButton.addActionListener(this);
        buttonPanel.add(backButton);

        // Add panels to the main panel
        mainPanel.add(listPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel);

        // Populate the list panel initially
        updateChampionList();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateChampionList();
    }

    private void updateChampionList() {
        listPanel.removeAll();
        final int length = championViewModel.getState().getLength();
        for (int i = 0; i < length; i++) {
            final JPanel championPanel = createChampionDetails(i);
            listPanel.add(championPanel);
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    private JPanel createChampionDetails(int index) {
        JPanel championPanel = new JPanel();
        championPanel.setLayout(new BoxLayout(championPanel, BoxLayout.Y_AXIS));
        championPanel.setBorder(BorderFactory.createTitledBorder("Champion " + (index + 1)));

        JLabel championId = new JLabel("Champion ID: " + championViewModel.getState().getChampionId(index));
        JLabel level = new JLabel("Level: " + championViewModel.getState().getChampionLevel(index));
        JLabel points = new JLabel("Points: " + championViewModel.getState().getChampionPoints(index));

        championPanel.add(championId);
        championPanel.add(level);
        championPanel.add(points);

        return championPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            backController.execute();
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setChampionViewModel(ChampionViewModel championViewModel) {
        this.championViewModel = championViewModel;
        updateChampionList();
    }
}
