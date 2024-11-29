package view;

import interface_adapter.Champion.ChampionController;
import interface_adapter.Champion.ChampionPresenter;

import javax.swing.*;
import java.awt.*;

public class ChampionView extends JFrame {

    public ChampionView(ChampionController controller, ChampionPresenter presenter) {
        setTitle("Top 3 Champions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Top 3 Champions");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        JButton fetchButton = new JButton("Fetch Champions");
        fetchButton.addActionListener(e -> {
            controller.onFetchTopChampionsClicked("summoner123", "NA");
            updateChampionList(panel, presenter);
        });
        panel.add(fetchButton);

        add(panel);
        setVisible(true);
    }

    private void updateChampionList(JPanel panel, ChampionPresenter presenter) {
        panel.removeAll();
        for (var champion : presenter.getChampions()) {
            JLabel label = new JLabel(champion.getChampionName() + " - " + champion.getMasteryPoints() + " points");
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);
        }
        panel.revalidate();
        panel.repaint();
    }
}
