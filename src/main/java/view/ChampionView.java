package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.champion.ChampionState;
import interface_adapter.champion.ChampionViewModel;
import entity.champion.Champion;


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;

/**
 * The View for displaying the top champions and their stats.
 */
public class ChampionView extends JPanel implements PropertyChangeListener {
    private final String viewName = "champion";
    private final ChampionViewModel championViewModel;
    private final JPanel championListPanel = new JPanel();
    private final JLabel errorLabel = new JLabel();

    public ChampionView(ChampionViewModel championViewModel, ViewManagerModel viewManagerModel) {
        this.championViewModel = championViewModel;
        this.championViewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Top Champions");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        championListPanel.setLayout(new BoxLayout(championListPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(championListPanel));

        // Back button
        JButton backButton = new JButton("Back to Login");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            viewManagerModel.setState("login");
            viewManagerModel.firePropertyChanged();
        });
        add(backButton);

        // Error label
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorLabel.setForeground(Color.RED);
        add(errorLabel);
    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            ChampionState state = (ChampionState) evt.getNewValue();
            updateUIFromState(state);
        }
    }

    private void updateUIFromState(ChampionState state) {
        championListPanel.removeAll();
        errorLabel.setText("");

        if (state.getFetchError() != null) {
            errorLabel.setText(state.getFetchError());
        } else {
            List<Champion> champions = state.getChampions();
            for (Champion champion : champions) {
                JPanel championPanel = createChampionPanel(champion);
                championListPanel.add(championPanel);
            }
        }

        championListPanel.revalidate();
        championListPanel.repaint();
    }

    private JPanel createChampionPanel(Champion champion) {
        JPanel championPanel = new JPanel();
        championPanel.setLayout(new BoxLayout(championPanel, BoxLayout.Y_AXIS));
        championPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        championPanel.setPreferredSize(new Dimension(200, 250));

        try {
            JLabel iconLabel = new JLabel(ChampionIcon.getChampionIcon(champion.getChampionName()));
            iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            championPanel.add(iconLabel);
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Icon not available");
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            championPanel.add(errorLabel);
        }

        JLabel nameLabel = new JLabel("Name: " + champion.getChampionName());
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        championPanel.add(nameLabel);

        JLabel killsLabel = new JLabel("Kills: " + champion.getKills());
        killsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        championPanel.add(killsLabel);

        JLabel magicDamageLabel = new JLabel("Magic Damage: " + champion.getMagicDamage());
        magicDamageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        championPanel.add(magicDamageLabel);

        JLabel physicalDamageLabel = new JLabel("Physical Damage: " + champion.getPhysicalDamage());
        physicalDamageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        championPanel.add(physicalDamageLabel);

        JLabel trueDamageLabel = new JLabel("True Damage: " + champion.getTrueDamage());
        trueDamageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        championPanel.add(trueDamageLabel);

        JLabel totalDamageLabel = new JLabel("Total Damage: " + champion.getTotalDamage());
        totalDamageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        championPanel.add(totalDamageLabel);

        JLabel masteryPointsLabel = new JLabel("Mastery Point: " + champion.getMasteryPoints());
        masteryPointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        championPanel.add(masteryPointsLabel);

        return championPanel;
    }
}
