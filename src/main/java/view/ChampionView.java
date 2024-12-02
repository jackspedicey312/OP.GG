package view;

import interface_adapter.champion.ChampionViewModel;
import interface_adapter.back.BackController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;


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
        this.championViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout());

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
        this.add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        listPanel.removeAll();
        System.out.println("Champion Mastery being generated");
        final int length = championViewModel.getState().getLength();
        System.out.println("Number of champions: " + length);
        for (int i = 0; i < length; i++) {
            final JPanel championPanel;
            try {
                championPanel = createChampionDetails(i);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            listPanel.add(championPanel);
        }
        listPanel.revalidate();
        listPanel.repaint();

    }

    private JPanel createChampionDetails(int index) throws IOException {
        JPanel championPanel = new JPanel(new GridBagLayout());
        championPanel.setBorder(BorderFactory.createTitledBorder("Highest Mastery Champion " + (index + 1)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel championLabel;
        ImageIcon championIcon1 = championViewModel.getState().getChampionIcon(index);
        if (championIcon1 != null) {
            final Image scaledImage = championIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            final ImageIcon championIcon2 = new ImageIcon(scaledImage);
            championLabel = new JLabel(championIcon2);
        }
        else {
            championLabel = new JLabel("No champion icon found");
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        championPanel.add(championLabel, gbc);

        JLabel championId = new JLabel("Champion: " + championViewModel.getState().getChampionName(index));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        championPanel.add(championId, gbc);

        JLabel level = new JLabel("Level: " + championViewModel.getState().getChampionLevel(index));
        gbc.gridy = 1;
        championPanel.add(level, gbc);

        JLabel points = new JLabel("Points: " + championViewModel.getState().getChampionPoints(index));
        gbc.gridy = 2;
        championPanel.add(points, gbc);

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

}
