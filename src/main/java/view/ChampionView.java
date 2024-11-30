package view;

import interface_adapter.Champion.ChampionController;
import interface_adapter.Champion.ChampionPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * ChampionView displays the top 3 champions with their icons and mastery points.
 */
public class ChampionView extends JFrame {

    public ChampionView(ChampionController controller, ChampionPresenter presenter) {
        setTitle("Top 3 Champions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Top 3 Champions");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);

        JButton fetchButton = new JButton("Fetch Champions");
        fetchButton.addActionListener(e -> {
            controller.onFetchTopChampionsClicked("summoner123", "NA");
            updateChampionList(mainPanel, presenter);
        });
        fetchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(fetchButton);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Updates the UI to display the list of champions.
     *
     * @param panel     The main panel to update.
     * @param presenter The presenter providing champion data.
     */
    private void updateChampionList(JPanel panel, ChampionPresenter presenter) {
        panel.removeAll();

        JLabel title = new JLabel("Top 3 Champions");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        for (var champion : presenter.getChampions()) {
            JPanel championPanel = new JPanel();
            championPanel.setLayout(new BoxLayout(championPanel, BoxLayout.Y_AXIS));
            championPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            championPanel.setPreferredSize(new Dimension(150, 200));

            try {
                // Fetch icon using ChampionIcon utility
                JLabel iconLabel = new JLabel(ChampionIcon.getChampionIcon(champion.getChampionName()));
                iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                championPanel.add(iconLabel);
            } catch (IOException e) {
                JLabel errorLabel = new JLabel("Icon not available");
                errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                championPanel.add(errorLabel);
            }

            JLabel nameLabel = new JLabel(champion.getChampionName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            championPanel.add(nameLabel);

            JLabel masteryLabel = new JLabel(champion.getMasteryPoints() + " points");
            masteryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            championPanel.add(masteryLabel);

            panel.add(championPanel);
        }

        panel.revalidate();
        panel.repaint();
    }
}
